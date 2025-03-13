module exerciciosfx {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.controlsfx.controls;
	requires javafx.web;
	requires javafx.media;
	
	opens layout;
	opens fxml;
	opens calculadora;
	opens javafxfinal;
	
	opens javafxfinal.componentes.animacao;
	opens javafxfinal.componentes.controles;
	opens javafxfinal.componentes.geral;
	opens javafxfinal.componentes.graficos;
	opens javafxfinal.componentes.interatividade;
	opens javafxfinal.componentes.menus;
	opens javafxfinal.componentes.navegacao;
	opens javafxfinal.componentes.paineis;
	opens javafxfinal.componentes.paineis.paineis;
}