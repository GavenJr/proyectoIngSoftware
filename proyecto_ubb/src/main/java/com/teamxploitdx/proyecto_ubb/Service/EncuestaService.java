package com.teamxploitdx.proyecto_ubb.Service;
import java.io.Console;
// imports de Java
import java.util.*;
// imports de spring boot
import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Empresa;
// imports locales
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;
import com.teamxploitdx.proyecto_ubb.Model.Pregunta;
import com.teamxploitdx.proyecto_ubb.Model.Respuesta;
import com.teamxploitdx.proyecto_ubb.Repository.EmpresaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.PreguntaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.RespuestaRepository;

@Service
public class EncuestaService {
    private final EncuestaRepository encuestaRepository;
    private final EmpresaRepository empresaRepository;
    private final PreguntaRepository preguntaRepository;
    private final RespuestaRepository respuestaRepository;

    public EncuestaService(EncuestaRepository encuestaRepository, EmpresaRepository empresaRepository, PreguntaRepository preguntaRepository, RespuestaRepository respuestaRepository ) {
        this.encuestaRepository = encuestaRepository;           // Con esto, sera posible hacer las asignaciones con el repositorio
        this.empresaRepository = empresaRepository;
        this.preguntaRepository = preguntaRepository;
        this.respuestaRepository = respuestaRepository;
    }

    /**
     Recupera todas las encuestas
     */
    public List<Encuesta> findAllEncuestas(){
        return encuestaRepository.findAll();
    }

    /**
     Encuentra las encuestas segun el nombre de una empresa
     @param nombre El nombre de la empresa
     */
    public List<Encuesta> findByEmpresa(String nombre){
        // Obtenemos referencia a la empresa de interes
        Optional<Empresa> empresa = empresaRepository.findEmpresaByNombre(nombre);
        // Si no hay empresa, retornamos una lista vacia
        if(empresa.isEmpty())
            return List.of();
        // Si no, retornamos las encuestas que tengan vinculadas a esa empresa
        return encuestaRepository.findByEmpresa(empresa);
    }

    /**
     * Recupera una encuesta por su nombre
     * @param nombre el nomnre de la encuesta
     * @return la encuesta
     */
    public Optional<Encuesta> findByName(String nombre){
        return encuestaRepository.findByNombre(nombre);
    }

    /**
     Encuentra las encuestas segun el nombre de una empresa
     @param id El id de la empresa
     */
    public Optional<Encuesta> findEncuestaById(int id){
        return encuestaRepository.findById(id);
    }

    /**
     Encuentra las encuestas segun el nombre de una empresa
     //@param id El id de la empresa
     */
    public Optional<Encuesta> findEncuestaByNombre(String nombre){
        return encuestaRepository.findByNombre(nombre);
    }

    /**
     * Intenta crear una encuesta, sincronizandola al repositorio
     * @param encuesta la encuesta proporcionada por el Json body
     * @return si la encuesta se creo o no
     */
    public boolean crearEncuesta(Encuesta encuesta){

        if(encuesta != null || encuesta.getEmpresa() != null)
            encuestaRepository.saveAndFlush( encuesta );

        Optional<Encuesta> encuestaOptional = encuestaRepository.findByNombre(encuesta.getNombre());
        return encuestaOptional.isPresent();
    }

    /**
     * Crea una encuesta asumiendo que el id de encuesta es autogenerado
     * @param idEmpresa el id de la empresa propietaria
     * @param nombre el nombre de la nueva encuesta
     * @return si la encuesta se creo o no
     */
    public boolean crearEncuesta(String nombre, int idEmpresa){
        Encuesta encuesta = new Encuesta(nombre, empresaRepository.findById(idEmpresa).get());

        if(encuesta != null || encuesta.getEmpresa() != null)
            encuestaRepository.saveAndFlush( encuesta );

        Optional<Encuesta> encuestaOptional = encuestaRepository.findByNombre(nombre);
        return encuestaOptional.isPresent();
    }

    /**
     * Crea una encuesta asumiendo que el id de encuesta NO es autogenerado
     * @param idEmpresa el id de la empresa propietaria
     * @param nombre el nombre de la nueva encuesta
     * @return si la encuesta se creo o no
     */
    public boolean crearEncuesta(int idEncuesta, String nombre, int idEmpresa){
        Encuesta encuesta = new Encuesta(idEncuesta, nombre, empresaRepository.findById(idEmpresa).get());

        if(encuesta != null || encuesta.getEmpresa() != null)
            encuestaRepository.saveAndFlush( encuesta );

        Optional<Encuesta> encuestaOptional = encuestaRepository.findByNombre(nombre);
        return encuestaOptional.isPresent();
    }

    /**
     * Borra una encuesta basado en su id
     * @param idEncuesta el id de la encuesta
     * @return true si se elimino, false si no
     */
    public boolean deleteEncuesta(int idEncuesta){
        encuestaRepository.delete( encuestaRepository.findById(idEncuesta).get() );
        if( encuestaRepository.findById(idEncuesta).isPresent() ){
            return false;
        }
        return true;
    }

    /**
     * Borra una encuesta basado en su nombre
     * @param nombre el nombre de la encuesta
     * @return true si se elimino, false si no
     */
    public boolean deleteEncuesta(String nombre){
        encuestaRepository.delete( encuestaRepository.findByNombre(nombre).get() );
        if( encuestaRepository.findByNombre(nombre).isPresent() ){
            return false;
        }
        return true;
    }

    /**
     Cambia la visibilidad de una encuesta
     @param idEncuesta El id de la encuesta
     */
    public boolean updateVisibilidad (int idEncuesta){

        Optional<Encuesta> encuestaOptional = encuestaRepository.findById(idEncuesta);
        Encuesta encuesta = encuestaOptional.get();

        if (encuestaOptional.isPresent()&&encuesta.isVisible()){
            encuesta.setVisible(false);
            encuestaRepository.save(encuesta);
            return true;
        }else{
            if (encuestaOptional.isPresent()&&!encuesta.isVisible()){
                encuesta.setVisible(true);
                encuestaRepository.save(encuesta);
                return true;
            }else{
                return false;
            }
        }
    }

    /**
     Actualiza el maximo de respuestas
     @param id El id de la encuesta
     @param newMax  Valor del nuevo maximo de encuestados
     */
    public boolean updateMaxRespuestas (int id, int newMax){

        Optional<Encuesta> encuestaOptional = encuestaRepository.findById(id);
        Encuesta encuesta = encuestaOptional.get();

        if (encuestaOptional.isPresent()){
            encuesta.setMax_respuestas(newMax);
            encuestaRepository.save(encuesta);
            return true;
        }else{
            return false;
        }
    }

    /**
     Actualiza el minimo de respuestas
     @param id El id de la encuesta
     @param newMin  Valor del nuevo minimo de encuestados
     */
    public boolean updateMinRespuestas (int id, int newMin){

        Optional<Encuesta> encuestaOptional = encuestaRepository.findById(id);
        Encuesta encuesta = encuestaOptional.get();

        if (encuestaOptional.isPresent()){
            encuesta.setMin_respuestas(newMin);
            encuestaRepository.save(encuesta);
            return true;
        }else{
            return false;
        }
    }

    /**
     Actualiza la descripcion de la encuesta
     @param id El id de la encuesta
     @param newDescripcion  Nueva descripcion para encuesta
     */
    public boolean updateDescripcion (int id, String newDescripcion){
        Optional<Encuesta> encuestaOptional = encuestaRepository.findById(id);
        Encuesta encuesta = encuestaOptional.get();
        if (encuestaOptional.isPresent()){
            encuesta.setDescripcion(newDescripcion);;
            encuestaRepository.save(encuesta);
            return true;
        }else{
            return false;
        }
    }
    /**
     obtiene la descripcion de la encuesta
     @param id El id de la encuesta
     */
    public String getDescripcion(int id){
        Optional<Encuesta> encuestaOptional = encuestaRepository.findById(id);
        Encuesta encuesta = encuestaOptional.get();
        return encuesta.getDescripcion();
    }


    public List<Encuesta> getAprobadas(){
        List<Encuesta> encuestas = encuestaRepository.findAll();

        List<Encuesta> aprobadas =  new ArrayList<Encuesta>();

        try {


            for (Encuesta encuesta : encuestas) {

                int id_encuesta = encuesta.getId();
                System.out.println("id enuesta : "+id_encuesta);

                List<Pregunta> preguntas = preguntaRepository.findAllPreguntaByEncuestaId(id_encuesta);
                int total_obligatorias  =  0;
                int total_obligatorias_respondidas = 0;
                for (Pregunta pregunta : preguntas) {
                    int id_pregunta = pregunta.getId();

                    // buscar respuesta
                    if (pregunta.getObligatoria()) {
                        total_obligatorias++;
                        Optional<Respuesta> respuesta = respuestaRepository.findRespuestaByPreguntaId(id_pregunta);
                        if (respuesta.isPresent())
                            total_obligatorias_respondidas++;



                    }

                }
                if (total_obligatorias == total_obligatorias_respondidas)
                    aprobadas.add(encuesta);







            }

        } catch (Exception e) {

        }

        return aprobadas;
    }


    public List<Encuesta> getPendientes(int id){
        List<Encuesta> pendientes =  new ArrayList<Encuesta>();


        System.out.println(id);
        List<Encuesta> encuestas = encuestaRepository.findAllEncuestaByEmpresaId(id);

        for (Encuesta encuesta : encuestas) {

            int id_encuesta = encuesta.getId();
            System.out.println("id enuesta : "+id_encuesta);

            List<Pregunta> preguntas = preguntaRepository.findAllPreguntaByEncuestaId(id_encuesta);
            int total_obligatorias  =  0;
            int total_obligatorias_respondidas = 0;
            for (Pregunta pregunta : preguntas) {

                int id_pregunta = pregunta.getId();
                System.out.println(id_pregunta);
                // buscar respuesta
                if (pregunta.getObligatoria()) {

                    total_obligatorias++;
                    Optional<Respuesta> respuesta = respuestaRepository.findRespuestaByPreguntaId(id_pregunta);
                    if (respuesta.isPresent())
                        total_obligatorias_respondidas++;


                }


            }

            if (total_obligatorias > total_obligatorias_respondidas)
                pendientes.add(encuesta);




        }
        return pendientes;
    }

}

