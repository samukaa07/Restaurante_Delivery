package br.com.restaurant.delivery.model.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.restaurant.delivery.model.cliente.Cliente;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

	private LocalDateTime data;

	private BigDecimal valorTotal = new BigDecimal("0");

	private BigDecimal desconto = new BigDecimal("0");
	
	
	public void calculaValorTotal() {
		itensPedido.forEach(i -> 
		this.valorTotal = new BigDecimal(this.valorTotal.toString()).add(i.getValorTotal()));
		this.data = LocalDateTime.now();
	}

	public void aplicaDesconto(BigDecimal desconto) {
		this.desconto = desconto;
		this.valorTotal = new BigDecimal(
				this.valorTotal.toString()).subtract(this.desconto);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
}
