package br.edu.ifsp.avaliacao1.Avaliacao1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.edu.ifsp.avaliacao1.Avaliacao1.Model.*;
import br.edu.ifsp.avaliacao1.Avaliacao1.Repository.*;
import java.util.*;

@Controller
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("seqProduct");
        model.addAttribute("product", new Product());
        return "product.html";
    }

    @GetMapping(path = "/{seqProduct}")
    public @ResponseBody Optional<Product> findById(@PathVariable(required = true, name = "seqProduct") Long seqProduct) {
        return productRepository.findById(seqProduct);
    }

    @GetMapping(path = "/list")
    public @ResponseBody Iterable<Product> list() {
        return productRepository.findAll();
    }

    @PostMapping(path = "/insert")
    public @ResponseBody String insert(@RequestBody Product product) {
        productRepository.save(product);
        return "Produto inserido com sucesso!";
    }

    @PutMapping(path = "/update/{seqProduct}")
    public @ResponseBody ResponseEntity<Product> update(@PathVariable(required = true, name = "seqProduct") Long seqProduct,
                                                        @RequestBody Product product) {
        Optional<Product> obj = productRepository.findById(seqProduct);
        if (obj.isPresent()) {
            obj.get().setNome(product.getNome());
            obj.get().setDescricao(product.getDescricao());
            obj.get().setMarca(product.getMarca());
            obj.get().setReferencia(product.getReferencia());
            obj.get().setPreco(product.getPreco());
            return ResponseEntity.ok(productRepository.save(obj.get()));
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping(path = "/delete/{seqProduct}")
    public @ResponseBody String delete(@PathVariable String seqProduct) {
        Optional<Product> product = productRepository.findById(Long.parseLong(seqProduct));
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return "Produto deletado com sucesso!";
        }

        return "Produto não encontrado.";
    }

}