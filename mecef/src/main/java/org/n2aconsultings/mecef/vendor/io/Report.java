package org.n2aconsultings.mecef.vendor.io;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.n2aconsultings.mecef.view.AlertError;

import java.util.HashMap;
import java.util.Map;

public class Report
{
    private static Report report;

    private final Database ds;

    private Report() {
        this.ds = new Database();
    }

    public static Report getInstance(){
        if(report==null){
            report = new Report();
        }
        return report;
    }

    public void createReport(String source, String query) {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(Report.class.getResourceAsStream(source));
            JRDesignQuery jrDesignQuery;
            (jrDesignQuery = new JRDesignQuery()).setText(query);
            jasperDesign.setQuery(jrDesignQuery);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, this.ds.getConnection());
            JasperViewer jasperViewer;
            (jasperViewer = new JasperViewer(jasperPrint, false)).setVisible(true);
        }
        catch (Exception e) {
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Connexion avec la base de donnée");
            AlertError.getInstance().setContentText("Impossible de créer le rapport : \n" + e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
    }

    public void createReport(String source, int id) {
        Map<String, Object> param = new HashMap<>();
        param.put("ID",id);
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(Report.class.getResourceAsStream(source));
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,param,this.ds.getConnection());
            JasperViewer jasperViewer;
            (jasperViewer = new JasperViewer(jasperPrint, false)).setVisible(true);
        }
        catch (Exception e) {
            AlertError.getInstance().setTitle("Erreur");
            AlertError.getInstance().setHeaderText("Connexion avec la base de donnée");
            AlertError.getInstance().setContentText("Impossible de créer le rapport : \n" + e.getMessage());
            AlertError.getInstance().showAndWait();
            e.printStackTrace();
        }
    }
}
