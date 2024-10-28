/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistencia.interfaces.IReporteDAO;

/**
 * Representa la generación de reportes
 * en un documento pdf
 * @author Beto_
 */
public class ReporteDAO implements IReporteDAO{
    private EntityManager entityManager;
    
    /**
     * Construye un reporteDAO con un entityManager
     * @param em 
     */
    public ReporteDAO(EntityManager em) {
        this.entityManager = em;
    }
    
    /**
     * Crea un documento pdf con un reporte acerca de los
     * apartados por laboratorios de computo
     * @param fechaInicio la fecha de inicio
     * @param fechaFin la fecha fin
     * @param idsCarreras las carreras a escoger
     * @param idLaboratorioComputo el laboratorio de computo del reporte
     * @throws PersistenciaException si no se puede crear el reporte
     */
    @Override
    public void reporteCentroComputo(LocalDate fechaInicio, LocalDate fechaFin, List<Long> idsCarreras, Long idLaboratorioComputo) throws PersistenciaException {
        try{
            //Crear un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("reporte_centro_computo.pdf"));
            document.open();

            //Agregar el título
            Paragraph titulo = new Paragraph("Reporte de centro de cómputo");
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            //Crear la tabla
            PdfPTable tabla = new PdfPTable(6);
            tabla.setWidthPercentage(100);
            
            //Agregar las cabeceras
            agregarCabeceras1(tabla);
            
            String jpql = "SELECT c.laboratorioComputo.nombre AS laboratorio, "
                + "       c.noMaquina, "
                + "       COUNT(a) AS numApartados, "
                + "       SUM(a.segundosActividad) AS segundosActividad, "
                + "       (l.horaFin - l.horaInicio - SUM(a.segundosActividad)) AS segundosInactividad, "
                + "       a.fecha "
                + "FROM ApartadoEntidad a "
                + "JOIN a.computadora c "
                + "JOIN c.laboratorioComputo l "
                + "WHERE a.fecha BETWEEN :fechaInicio AND :fechaFin ";

            // Agregar condiciones de filtro si es necesario
            if (idLaboratorioComputo != null) {
                jpql += "AND c.laboratorioComputo.id = :idLaboratorioComputo ";
            }
            if (idsCarreras != null && !idsCarreras.isEmpty()) {
                jpql += "AND a.estudiante.carrera.id IN :idsCarreras ";
            }

            jpql += "GROUP BY c.laboratorioComputo.nombre, c.noMaquina, a.fecha";

            Query query = entityManager.createQuery(jpql.toString());
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            
            if (idLaboratorioComputo != null) {
                query.setParameter("idLaboratorioComputo", idLaboratorioComputo);
            }
            if (idsCarreras != null && !idsCarreras.isEmpty()) {
                query.setParameter("idsCarreras", idsCarreras);
            }
            
            List<Object[]> results = query.getResultList();

            // Agregar los datos a la tabla
            for (Object[] row : results) {
                PdfPCell cell;
                cell = new PdfPCell(new Phrase(row[0].toString())); //Nombre del centro de cómputo
                tabla.addCell(cell);
                cell = new PdfPCell(new Phrase(row[1].toString())); //Número de computadora
                tabla.addCell(cell);
                cell = new PdfPCell(new Phrase(row[2].toString())); //cantidad de alumnos
                tabla.addCell(cell);
                cell = new PdfPCell(new Phrase(row[3].toString())); //segundos de uso
                tabla.addCell(cell);
                cell = new PdfPCell(new Phrase(row[4].toString())); //tiempo de inactividad
                tabla.addCell(cell);
                cell = new PdfPCell(new Phrase(row[5].toString())); //Fecha
                tabla.addCell(cell);
            }

            // Agregar la tabla al documento
            document.add(tabla);
            document.close();    
            
        }catch(Exception e){
            throw new PersistenciaException("No se pudo hacer el reporte: " + e.getMessage());
        }
    }
    
    /**
     * Crea un documento pdf con un reporte acerca de los
     * apartados por carreras
     * @param fechaInicio la fecha de inicio
     * @param fechaFin la fecha fin
     * @param ids_carreras las carreras a elegir
     * @throws PersistenciaException si no se puede crear el reporte
     */
    @Override
    public void reporteCarreras(LocalDate fechaInicio, LocalDate fechaFin, List<Long> ids_carreras) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Crea un documento pdf con un reporte de los
     * bloqueos
     * @param fechaInicio la fecha de inicio
     * @param fechaFin la fecha fin
     * @throws PersistenciaException Si no se puede crear el reporte 
     */
    @Override
    public void reporteBloqueos(LocalDate fechaInicio, LocalDate fechaFin) throws PersistenciaException {
        try{
            // Crear un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("reporte_bloqueos.pdf"));
            document.open();

            // Agregar el título
            Paragraph titulo = new Paragraph("Reporte de bloqueos");
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            // Crear la tabla
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            
            // Agregar las cabeceras
            agregarCabeceras3(tabla);
            
            String jpql = 
            "SELECT CONCAT(e.nombres, ' ', e.apellidoPaterno, ' ', e.apellidoMaterno) AS nombreCompleto, " +
            "       eb.fechaInicio, COALESCE(eb.fechaFin, 'N/A'), b.motivo " +
            "FROM EstudianteBloqueoEntidad eb " +
            "JOIN eb.estudiante e " +
            "JOIN eb.bloqueo b " +
            "WHERE eb.fechaInicio BETWEEN :fechaInicio AND :fechaFin";

            Query query = entityManager.createQuery(jpql, Object[].class);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);

            List<Object[]> results = query.getResultList();
            
            // Agregar los datos a la tabla
            for (Object[] row : results) {
                PdfPCell cell;
                cell = new PdfPCell(new Phrase(row[0].toString())); // Nombre dl alumno
                tabla.addCell(cell);
                cell = new PdfPCell(new Phrase(row[1].toString())); // Fecha de bloqueo
                tabla.addCell(cell);
                cell = new PdfPCell(new Phrase(row[2].toString())); // Fecha de liberación
                tabla.addCell(cell);
                cell = new PdfPCell(new Phrase(row[3].toString())); // Motivo
                tabla.addCell(cell);
            }
            // Agregar la tabla al documento
            document.add(tabla);
            document.close(); 
            
        }catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException("No se pudo hacer el reporte: " + e.getMessage());
        }
    }
    
    /**
     * Agrega los nombres de las columnas del primer reporte
     * @param table la tabla del reporte
     */
    public void agregarCabeceras1(PdfPTable table){
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Nombre del centro de cómputo"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Número de computadora"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cantidad de alumnos"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Segundos de uso por día"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("tiempo de inactividad"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Fecha"));
        table.addCell(cell);
    }
    
    /**
     * Agrega los nombres de las columnas del segundo reporte
     * @param table la tabla del reporte
     */
    public void agregarCabeceras2(PdfPTable table){
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Nombre de la carrera"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Minutos de uso por día"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cantidad de alumnos"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Fecha"));
        table.addCell(cell);
    }
    
    /**
     * Agrega los nombres de las columnas del tercer reporte
     * @param table la tabla del reporte
     */
    public void agregarCabeceras3(PdfPTable table){
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Nombre del alumno"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Fecha de bloqueo"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Fecha de liberacion"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Motivo"));
        table.addCell(cell);
    }
    
}
