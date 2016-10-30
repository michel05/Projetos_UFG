package br.com.trabalho2.modularidade;

import java.awt.Frame;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

import javax.swing.JFileChooser;

public class Metrica1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		Frame frame = new Frame();
		chooser.showOpenDialog(frame);
		File[] files = chooser.getSelectedFiles();

		int qtdeLinhas = 0;

		for (File file : files) {
			LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(file));
			linhaLeitura.skip(file.length());
			int qtdLinha = linhaLeitura.getLineNumber();

			System.out.println(file.getName() + " qtdeLinhas: " + qtdLinha);
			qtdeLinhas += qtdLinha;
		}

		System.out.println("Quantidade de linhas total: " + qtdeLinhas);
		double complexidade = (double) qtdeLinhas / files.length;
		
		System.out.println("Quantidade de linhas médio: " + complexidade);
		
	}

}
