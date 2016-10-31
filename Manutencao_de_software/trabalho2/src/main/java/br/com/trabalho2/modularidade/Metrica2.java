package br.com.trabalho2.modularidade;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

public class Metrica2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		Frame frame = new Frame();
		chooser.showOpenDialog(frame);
		File[] files = chooser.getSelectedFiles();

		List<String> nomesFiles = new ArrayList<String>();

		for (File file : files) {
			nomesFiles.add(file.getName().replace(".java", ""));
		}

		int qtdeDepedencia = 0;

		for (File file : files) {
			BufferedReader buffRead = new BufferedReader(new FileReader(file));

			String linha = "";
			String texto = "";
			while (true) {
				if (linha != null) {
					texto += linha;
				} else
					break;
				linha = buffRead.readLine();
			}

			for (String string : nomesFiles) {
				if (texto.contains(string) && !file.getName().replace(".java", "").equals(string)
						&& !file.getName().replace(".java", "").contains(string)) {
					System.out.println(string);
					qtdeDepedencia++;
				}
			}

			System.out.println("Acoplamento da classe " + file.getName().replace(".java", "") + ": " + qtdeDepedencia);
			qtdeDepedencia = 0;
			texto = "";
			linha = "";
		}

	}

}
