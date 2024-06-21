package br.com.api.fatec.apifatec;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.api.fatec.apifatec.entities.PedidoVenda;
import br.com.api.fatec.apifatec.entities.PedidoVendaItem;
import br.com.api.fatec.apifatec.shared.enums.PedidoVendaStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.api.fatec.apifatec.domain.cliente.ClienteRepository;
import br.com.api.fatec.apifatec.domain.pedidovenda.PedidoVendaRepository;
import br.com.api.fatec.apifatec.domain.produto.ProdutoRepository;
import br.com.api.fatec.apifatec.entities.Cliente;
import br.com.api.fatec.apifatec.entities.Produto;

@SpringBootApplication
public class ApiFatecApplication {
    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository clienteRepository,
                                 @Autowired ProdutoRepository produtoRepository,
                                 @Autowired PedidoVendaRepository pedidoVendaRepository
                                 ) {
        return args -> {
            // Clientes
            Cliente cliente1 = new Cliente();
            cliente1.setNome("Danilo");
            cliente1.setEmail("h2danilofatec@hotmail.com");
            cliente1.setEndereco("Rua xxx, 126");
            cliente1.setRazaoSocial("Danilo");
            clienteRepository.save(cliente1);

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Arthur");
            cliente2.setEmail("h2danilosfatec@hotmail.com");
            cliente2.setEndereco("Rua xxx, 126");
            cliente2.setRazaoSocial("Arthur");
            clienteRepository.save(cliente2);

            Cliente cliente3 = new Cliente();
            cliente3.setNome("Pedro");
            cliente3.setEmail("pedro@hotmail.com");
            cliente3.setEndereco("Rua xxx, 1");
            cliente3.setRazaoSocial("Pedro");
            clienteRepository.save(cliente3);

            Cliente cliente4 = new Cliente();
            cliente4.setNome("Marcos");
            cliente4.setEmail("marcos@hotmail.com");
            cliente4.setEndereco("Rua ipiranga, 126");
            cliente4.setRazaoSocial("Marcos");
            clienteRepository.save(cliente4);

            Cliente cliente5 = new Cliente();
            cliente5.setNome("Rafael");
            cliente5.setEmail("rafael@hotmail.com");
            cliente5.setEndereco("Rua 2, 126");
            cliente5.setRazaoSocial("Rafael");
            clienteRepository.save(cliente5);

            // Produtos
            Produto produto1 = new Produto();
            produto1.setDescricao("Calça");
            produto1.setPreco(new BigDecimal(100));
            produto1.setAtivo("SIM");
            produto1.setQuantidadeEstoque(50);
            produtoRepository.save(produto1);

            Produto produto2 = new Produto();
            produto2.setDescricao("Camisa");
            produto2.setPreco(new BigDecimal(80));
            produto2.setAtivo("SIM");
            produto2.setQuantidadeEstoque(30);
            produtoRepository.save(produto2);

            Produto produto3 = new Produto();
            produto3.setDescricao("Tênis");
            produto3.setPreco(new BigDecimal(120));
            produto3.setAtivo("SIM");
            produto3.setQuantidadeEstoque(60);
            produtoRepository.save(produto3);

            Produto produto4 = new Produto();
            produto4.setDescricao("Meia");
            produto4.setPreco(new BigDecimal(15));
            produto4.setAtivo("SIM");
            produto4.setQuantidadeEstoque(90);
            produtoRepository.save(produto4);

            Produto produto5 = new Produto();
            produto5.setDescricao("Bolsa");
            produto5.setPreco(new BigDecimal(200));
            produto5.setAtivo("SIM");
            produto5.setQuantidadeEstoque(30);
            produtoRepository.save(produto5);

            // Pedidos de Venda
            PedidoVenda pedido1 = new PedidoVenda();
            pedido1.setCliente(cliente1);
            pedido1.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            pedido1.setEmissao(LocalDate.now());

            PedidoVendaItem item1Pedido1 = new PedidoVendaItem();
            item1Pedido1.setProduto(produto1);
            item1Pedido1.setQuantidade(5);
            item1Pedido1.setValorUnitario(produto1.getPreco());
            item1Pedido1.setValorTotal(item1Pedido1.getValorUnitario().multiply(BigDecimal.valueOf(item1Pedido1.getQuantidade())));
            pedido1.addItem(item1Pedido1);

            pedidoVendaRepository.save(pedido1);

            PedidoVenda pedido2 = new PedidoVenda();
            pedido2.setCliente(cliente2);
            pedido2.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            pedido2.setEmissao(LocalDate.now());

            PedidoVendaItem item1Pedido2 = new PedidoVendaItem();
            item1Pedido2.setProduto(produto1);
            item1Pedido2.setQuantidade(2);
            item1Pedido2.setValorUnitario(produto1.getPreco());
            item1Pedido2.setValorTotal(item1Pedido2.getValorUnitario().multiply(BigDecimal.valueOf(item1Pedido2.getQuantidade())));
            pedido2.addItem(item1Pedido2);

            PedidoVendaItem item2Pedido2 = new PedidoVendaItem();
            item2Pedido2.setProduto(produto2);
            item2Pedido2.setQuantidade(3);
            item2Pedido2.setValorUnitario(produto2.getPreco());
            item2Pedido2.setValorTotal(item2Pedido2.getValorUnitario().multiply(BigDecimal.valueOf(item2Pedido2.getQuantidade())));
            pedido2.addItem(item2Pedido2);

            pedidoVendaRepository.save(pedido2);

            PedidoVenda pedido3 = new PedidoVenda();
            pedido3.setCliente(cliente3);
            pedido3.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            pedido3.setEmissao(LocalDate.now());

            PedidoVendaItem item1Pedido3 = new PedidoVendaItem();
            item1Pedido3.setProduto(produto3);
            item1Pedido3.setQuantidade(1);
            item1Pedido3.setValorUnitario(produto3.getPreco());
            item1Pedido3.setValorTotal(item1Pedido3.getValorUnitario().multiply(BigDecimal.valueOf(item1Pedido3.getQuantidade())));
            pedido3.addItem(item1Pedido3);

            pedidoVendaRepository.save(pedido3);

            PedidoVenda pedido4 = new PedidoVenda();
            pedido4.setCliente(cliente4);
            pedido4.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            pedido4.setEmissao(LocalDate.now());

            PedidoVendaItem item1Pedido4 = new PedidoVendaItem();
            item1Pedido4.setProduto(produto4);
            item1Pedido4.setQuantidade(4);
            item1Pedido4.setValorUnitario(produto4.getPreco());
            item1Pedido4.setValorTotal(item1Pedido4.getValorUnitario().multiply(BigDecimal.valueOf(item1Pedido4.getQuantidade())));
            pedido4.addItem(item1Pedido4);

            pedidoVendaRepository.save(pedido4);

            PedidoVenda pedido5 = new PedidoVenda();
            pedido5.setCliente(cliente5);
            pedido5.setStatus(PedidoVendaStatusEnum.CONCLUIDO);
            pedido5.setEmissao(LocalDate.now());

            PedidoVendaItem item1Pedido5 = new PedidoVendaItem();
            item1Pedido5.setProduto(produto5);
            item1Pedido5.setQuantidade(2);
            item1Pedido5.setValorUnitario(produto5.getPreco());
            item1Pedido5.setValorTotal(item1Pedido5.getValorUnitario().multiply(BigDecimal.valueOf(item1Pedido5.getQuantidade())));
            pedido5.addItem(item1Pedido5);

            pedidoVendaRepository.save(pedido5);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiFatecApplication.class, args);
    }
}
