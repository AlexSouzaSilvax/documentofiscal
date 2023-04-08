package com.documentofiscal.documentofiscal.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.documentofiscal.documentofiscal.model.DocumentoFiscal;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@CrossOrigin("*")
@RestController(value = "documento-fiscal")
@RequestMapping(name = "documento-fiscal", value = "documento-fiscal")
public class DocumentoFiscalController {
	@PostMapping("pdf")
	public void teste(HttpServletResponse response, @RequestBody DocumentoFiscal documentoFiscal)
			throws IOException {
		/*
		 * params 03/09/2021
		 * CONSTRUTORA BIAPÓ LTDA.
		 * Av. Nossa Senhora de Copacabana, 308 Apto 511
		 * Rio de Janeiro RJ
		 * 25.078.452/0003-89
		 * Transferência de material da obra do museu Nacional para obra do Ministério.
		 * 600,00
		 * Seiscentos reais
		 * Itaú Ag 7208 Cc 07296 2
		 * allancosta030405@gmail.com
		 */

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream("./documento.pdf"));

			document.open();

			document.add(
					new Paragraph("               DOCUMENTO FISCAL DE SERVIÇOS DE MICROEMPREENDEDOR INDIVIDUAL"));
			document.add(new Paragraph(
					"                                             Art. 3° § 1º Decreto 31.184 de 05/10/2009"));

			document.add(
					new Paragraph("                                                            Extraído em duas vias"));
			document.add(new Paragraph(
					"\n\n                                          ALLAN COSTA DA SILVA 08432913707 - MEI"));
			document.add(new Paragraph(
					"\n         Rua Doutor Getúlio de Moura, 290 – Jardim Iguaçu – Nova Iguaçu – RJ CEP 26.281-85"));
			document.add(
					new Paragraph("                                                          CNPJ 34.800.365/0001-12"));
			document.add(new Paragraph(
					"                                                          Data da Emissão: "
							+ documentoFiscal.getDtEmissao()));
			document.add(new Paragraph("                                                                       Nº "
					+ documentoFiscal.getNumeroNota())); // 01/10-02
			document.add(new Paragraph(
					"                                                          1ª Via: Tomador do Serviço"));
			document.add(new Paragraph("\n\n           Tomador do(s) Serviço(s)"));
			document.add(new Paragraph("\n                 Nome: " + documentoFiscal.getNmCliente()));
			document.add(new Paragraph("                 Endereço: " + documentoFiscal.getEndCliente()));
			document.add(new Paragraph("                 Município/UF: " + documentoFiscal.getMuniUfCliente()));
			document.add(new Paragraph("                 CPF: " + documentoFiscal.getCnpjCliente()));
			document.add(new Paragraph("\n\n           Discriminação dos Serviços"));
			document.add(new Paragraph(
					"\n                 " + documentoFiscal.getDescServicos()));
			document.add(new Paragraph("                 Valor  R$ " + documentoFiscal.getValor() + " ("
					+ documentoFiscal.getValorEx() + ")."));
			document.add(new Paragraph("\n\n           Dados bancários"));
			document.add(new Paragraph("\n                 Allan Costa da Silva"));
			document.add(new Paragraph("                 084.329.137-07"));
			document.add(new Paragraph("                 Banco " + documentoFiscal.getBanco()));
			document.add(new Paragraph("                 Pix " + documentoFiscal.getPix()));
			document.add(new Paragraph(
					"\n\n\n                                                                    Assinatura"));
			document.add(new Paragraph("\n"));
			Image img = Image.getInstance("assinatura.jpg");
			img.scaleToFit((float) 200.0, (float) 49.0);
			img.setAlignment(5);
			document.add(img);
			document.add(
					new Paragraph("______________________________________________________________________________"));

		} catch (DocumentException ex) {
			System.out.println("Error:" + ex);
		} catch (FileNotFoundException ex) {
			System.out.println("Error:" + ex);
		} finally {
			document.close();
		}

		File arquivo = new File("documento.pdf");
		java.nio.file.Path path = (java.nio.file.Path) arquivo.toPath();

		HttpServletResponse resp = response; // pega response da servlet ou framework mvc
		OutputStream output = resp.getOutputStream();

		Files.copy(path, output); // escreve bytes no fluxo de saída

	}
}
