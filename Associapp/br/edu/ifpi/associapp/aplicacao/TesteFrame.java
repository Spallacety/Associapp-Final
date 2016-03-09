package br.edu.ifpi.associapp.aplicacao;

import javax.swing.JFrame;

public class TesteFrame {
	
	public static void main(String[] args) {
//		JFrame janela = new JFrame ("Nova janela");
//
//		janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//		janela.add(meuPainel);
//		janela.setSize(600, 400);
//		janela.setVisible(true);
		
		JFrame jf = new JFrame("title"); 
		jf.setSize(300, 200); // width, height in pixels (required)
		jf.setVisible(true); // (required)
		jf.setTitle("New Title");
		jf.setLocation(50, 100); // x and y from upper-left corne
		
	}
	
	
}
