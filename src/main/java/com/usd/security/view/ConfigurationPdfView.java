package com.usd.security.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.usd.security.entity.Configuration;

public class ConfigurationPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachement;filename=uoms.pdf");
		Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLACK);
		Paragraph p = new Paragraph("Configuration Data");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<Configuration> cnfs = (List<Configuration>) model.get("list");
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		table.setSpacingBefore(10);
		table.addCell("Id");
		table.addCell("getName");
		table.addCell("getType");
		table.addCell("getCompletLogPath");
		for (Configuration u : cnfs) {

			table.addCell(u.getCnfId().toString());
			table.addCell(u.getName());
			table.addCell(u.getType());
			table.addCell(u.getCompletLogPath());

		}

		document.add(table);
		document.add(new Paragraph(new Date().toString()));

	}

}
