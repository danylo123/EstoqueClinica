package estocmed.produtoconsumo;

import estocmed.estoqueconsumo.EstoqueConsumo;
import estocmed.fornecedor.Fornecedor;
import estocmed.tipodoproduto.TipoDoProduto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProdutoConsumo implements Serializable {

    @Id
    @GeneratedValue
    private int idProduto;

    @Column(length = 100, nullable = false)
    private String nomeProdutoConsumo;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idTipoProduto")
    private TipoDoProduto tipoProduto;


//    @Override
//    public int compareTo(ProdutoConsumo produtoConsumo) {
//        return this.nomeProdutoConsumo.compareTo(produtoConsumo.getNomeProdutoConsumo());
//    }
    
    public TipoDoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoDoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProdutoConsumo() {
        return nomeProdutoConsumo;
    }

    public void setNomeProdutoConsumo(String nomeProdutoConsumo) {
        this.nomeProdutoConsumo = nomeProdutoConsumo;
    }

}
