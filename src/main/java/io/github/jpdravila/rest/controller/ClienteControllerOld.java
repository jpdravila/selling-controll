package io.github.jpdravila.rest.controller;

/*@Controller*/
public class ClienteControllerOld {

    /*public ClienteRepository clientes;
    public ClienteControllerOld(ClienteRepository clientes){
        this.clientes = clientes;
    }

    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id ){
       Optional<Cliente> cliente = clientes.findById(id);
       if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
       }

       return ResponseEntity.notFound().build();

    }

    @PostMapping("api/clientes")
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente cliente){
        Cliente clienteSalvo = clientes.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<Cliente> cliente = clientes.findById(id);
        if(cliente.isPresent()){
            clientes.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/api/clientes/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Cliente cliente){

        return clientes
                .findById(id).map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return ResponseEntity.noContent().build();
                } ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/api/clientes")
    public ResponseEntity find(Cliente filtro){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = clientes.findAll(example);
        return ResponseEntity.ok(lista);
    }*/
}
