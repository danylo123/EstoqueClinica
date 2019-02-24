/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.util;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import estocmed.curso.Curso;
import estocmed.destino.Destino;
import estocmed.estoqueconsumo.EstoqueConsumo;
import estocmed.saidaconsumo.SaidaConsumo;
import estocmed.usuario.Usuario;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karlos Oliveira
 */
public class Relatorios {

    private static SimpleDateFormat formatarData = new SimpleDateFormat("dd-MM-yyyy(HH-mm-ss)");
    private static Document document = new Document(PageSize.A4);

    private static void gerarCabecalho(String cabecalho) {
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font fontLinha = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
        fontLinha.setColor(41, 72, 59);
        Font fontLinhaMenor = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        fontLinhaMenor.setColor(BaseColor.BLUE);

        document.open();
        PdfPTable tabela = new PdfPTable(1);
        PdfPCell celula1;
        try {
            celula1 = new PdfPCell(Image.getInstance("imagens/fvs.png"));
            celula1.setBorder(-1);
            celula1.setIndent(155);
            tabela.addCell(celula1);
            document.add(tabela);
        } catch (BadElementException ex) {
            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Paragraph fvs = new Paragraph("FACULDADE VALE DO SALGADO", boldFont);
            fvs.setAlignment(Element.ALIGN_CENTER);
            document.add(fvs);

            Paragraph titulo = new Paragraph(cabecalho, boldFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            Paragraph linha0 = new Paragraph("________________________________", fontLinhaMenor);
            linha0.setAlignment(Element.ALIGN_CENTER);
            linha0.setSpacingAfter(-21);
            linha0.setSpacingBefore(-21);
            document.add(linha0);

            Paragraph linha2 = new Paragraph("______________________________________________", fontLinha);
            linha2.setAlignment(Element.ALIGN_CENTER);
            document.add(linha2);

            Paragraph linha3 = new Paragraph("________________________________", fontLinhaMenor);
            linha3.setAlignment(Element.ALIGN_CENTER);
            linha3.setSpacingBefore(-16);
            document.add(linha3);

            Paragraph linha4 = new Paragraph("");
            linha4.setAlignment(Element.ALIGN_CENTER);
            linha4.setSpacingBefore(20);
            document.add(linha4);

        } catch (com.itextpdf.text.DocumentException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String converterDataString(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return f.format(date);
    }

    public static void gerarRelatorioTabelaSaida(List<SaidaConsumo> saidas) {
        String diretorioPdf = "relatorios/estoqueConsumo/" + formatarData.format(new Date()) + ".pdf";
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

        try {
            try {
                PdfWriter.getInstance(document, new FileOutputStream(diretorioPdf));
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.open();
            gerarCabecalho("Bird Stork - Saída de Produtos");

            PdfPTable tabela = new PdfPTable(6);

            PdfPCell celulaTituloID = new PdfPCell(new Phrase("Sequência", boldFont));
            PdfPCell celulaTituloNome = new PdfPCell(new Phrase("Produto", boldFont));
            PdfPCell celulaTituloDestino = new PdfPCell(new Phrase("Destino", boldFont));
            PdfPCell celulaTituloCurso = new PdfPCell(new Phrase("Curso", boldFont));
            PdfPCell celulaTituloSaida = new PdfPCell(new Phrase("Qtd. Saída", boldFont));
            PdfPCell celulaTituloVencimento = new PdfPCell(new Phrase("Dt. Saída", boldFont));

            tabela.addCell(celulaTituloID);
            tabela.addCell(celulaTituloNome);
            tabela.addCell(celulaTituloDestino);
            tabela.addCell(celulaTituloCurso);
            tabela.addCell(celulaTituloSaida);
            tabela.addCell(celulaTituloVencimento);

            int indexQuantidade = 0;
            int sequencia = 0;
            for (SaidaConsumo saidaConsumo : saidas) {
                for (EstoqueConsumo estoqueConsumo : saidaConsumo.getEstoqueConsumo()) {
                    sequencia++;
                    PdfPCell celulaID = new PdfPCell(new Phrase(String.valueOf(sequencia)));
                    PdfPCell celulaNome = new PdfPCell(new Phrase(estoqueConsumo.getProduto().getNomeProdutoConsumo()));
                    PdfPCell celulaDestino = new PdfPCell(new Phrase(saidaConsumo.getDestino().getNomeDestino()));
                    PdfPCell celulaCurso = new PdfPCell(new Phrase(estoqueConsumo.getCurso().getNomeCurso()));
                    PdfPCell celulaSaida = new PdfPCell(new Phrase(String.valueOf(saidaConsumo.getQuantidadeSaidaDestino(indexQuantidade))));
                    PdfPCell celulaVencimento = new PdfPCell(new Phrase(converterDataString(saidaConsumo.getDataSaida())));

                    tabela.addCell(celulaID);
                    tabela.addCell(celulaNome);
                    tabela.addCell(celulaDestino);
                    tabela.addCell(celulaCurso);
                    tabela.addCell(celulaSaida);
                    tabela.addCell(celulaVencimento);
                    indexQuantidade++;
                }
                indexQuantidade = 0;
            }

            tabela.setWidthPercentage(100);
            document.add(tabela);

            Desktop.getDesktop().open(new File(diretorioPdf));
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
        document.close();
        limparGeral();
    }

    public static void gerarRelatorioTabelaVencimento(List<EstoqueConsumo> estoques) {
        String diretorioPdf = "relatorios/estoqueConsumo/" + formatarData.format(new Date()) + ".pdf";
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

        try {
            try {
                PdfWriter.getInstance(document, new FileOutputStream(diretorioPdf));
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.open();
            gerarCabecalho("Bird Stork - Vencimento Estoque");

            PdfPTable tabela = new PdfPTable(5);

            PdfPCell celulaTituloID = new PdfPCell(new Phrase("Sequência", boldFont));
            PdfPCell celulaTituloNome = new PdfPCell(new Phrase("Produto", boldFont));
            PdfPCell celulaTituloCurso = new PdfPCell(new Phrase("Curso", boldFont));
            PdfPCell celulaTituloSaida = new PdfPCell(new Phrase("Qtd. Saída", boldFont));
            PdfPCell celulaTituloVencimento = new PdfPCell(new Phrase("Dt. Vencimento", boldFont));

            tabela.addCell(celulaTituloID);
            tabela.addCell(celulaTituloNome);
            tabela.addCell(celulaTituloCurso);
            tabela.addCell(celulaTituloSaida);
            tabela.addCell(celulaTituloVencimento);

            int sequencia = 1;
            for (EstoqueConsumo estoqueConsumo : estoques) {

                PdfPCell celulaID = new PdfPCell(new Phrase(String.valueOf(sequencia)));
                PdfPCell celulaNome = new PdfPCell(new Phrase(estoqueConsumo.getProduto().getNomeProdutoConsumo()));
                PdfPCell celulaCurso = new PdfPCell(new Phrase(estoqueConsumo.getCurso().getNomeCurso()));
                PdfPCell celulaSaida = new PdfPCell(new Phrase(estoqueConsumo.getQtdSaida().toString()));
                PdfPCell celulaVencimento = new PdfPCell(new Phrase(converterDataString(estoqueConsumo.getVencimentoProdConsumo())));

                tabela.addCell(celulaID);
                tabela.addCell(celulaNome);
                tabela.addCell(celulaCurso);
                tabela.addCell(celulaSaida);
                tabela.addCell(celulaVencimento);
                sequencia++;
            }

            tabela.setWidthPercentage(100);
            document.add(tabela);

            Desktop.getDesktop().open(new File(diretorioPdf));
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
        document.close();
        limparGeral();
    }

    private static void limparGeral() {
        document = new Document();
    }

    public static void relatorioSaidaEstoqueConsumo(List<EstoqueConsumo> estoques, Usuario usuario, Destino destino) {
        SimpleDateFormat formatarData2 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatarData3 = new SimpleDateFormat("HH:mm:ss");
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);

        String diretorioPdf = "relatorios/estoqueConsumo/" + formatarData.format(new Date()) + ".pdf";

        try {

            try {
                PdfWriter.getInstance(document, new FileOutputStream(diretorioPdf));
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.open();
            gerarCabecalho("Bird Stork - Saída de Produtos");

            try {
                Paragraph linha2 = new Paragraph("Destino: " + destino.getNomeDestino(), boldFont);
                Paragraph linha3 = new Paragraph("Data de Saída: " + formatarData2.format(new Date()) + " Hora: " + formatarData3.format(new Date()), boldFont);

                document.add(linha2);
                document.add(linha3);
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                document.add(new Paragraph(" "));
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }

            PdfPTable tabela = new PdfPTable(2);

            PdfPCell celulaTituloNome = new PdfPCell(new Phrase("Nome Produto", boldFont));
            PdfPCell celulaQtdSaida = new PdfPCell(new Phrase("Quantidade de Saída", boldFont));

            tabela.addCell(celulaTituloNome);
            tabela.addCell(celulaQtdSaida);

            for (EstoqueConsumo estoque : estoques) {

                PdfPCell str1 = new PdfPCell(new Phrase(estoque.getProduto().getNomeProdutoConsumo()));
                PdfPCell str2 = new PdfPCell(new Phrase(String.valueOf(estoque.getQtdSaidaAtual())));

                tabela.addCell(str1);
                tabela.addCell(str2);
            }

            tabela.setWidthPercentage(100);
            try {
                document.add(tabela);
            } catch (com.itextpdf.text.DocumentException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }

            Desktop.getDesktop().open(new File(diretorioPdf));
        } catch (IOException de) {
            System.err.println(de.getMessage());
        }

        try {
            Paragraph linha = new Paragraph();
            linha.add(new Paragraph(" "));
            document.add(linha);
            linha.add(new Paragraph("Recebido por: ________________________________", boldFont));
            linha.setAlignment(Element.ALIGN_RIGHT);
            document.add(linha);
        } catch (DocumentException ex) {
            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Paragraph linha = new Paragraph();
            linha.add(new Paragraph(" "));
            document.add(linha);
            linha.add(new Paragraph("Entregue por: " + usuario.getNomeUsuario(), boldFont));
            linha.setAlignment(Element.ALIGN_RIGHT);
            document.add(linha);
        } catch (DocumentException ex) {
            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.close();
        limparGeral();
    }

}
