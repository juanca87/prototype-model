/*
 * MIT License
 *
 * Copyright (c) 2017 JUAN CALVOPINA M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.jcalvopinam.client.web;

import com.jcalvopinam.client.domain.ResultadoEjecucion;
import com.jcalvopinam.client.service.ResultadoEjecucionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jcalvopinam.client.utils.Commons.getErrorMessage;
import static com.jcalvopinam.client.utils.Commons.getHpptHeader;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 */
@Controller
public class ResultadoEjecucionController {

    private static final Logger log = LoggerFactory.getLogger(ResultadoEjecucionController.class);

    List<?> json;

    @Autowired
    private ResultadoEjecucionService resultadoEjecucion;

    /**
     * Guarda el resultado de la ejecucion
     */
    @RequestMapping(value = "/saveResultadoEjecucion", consumes = "application/json", method = RequestMethod.POST)
    public String save(@RequestBody ResultadoEjecucion resultadoJson, ModelMap model) {

        model.addAttribute("title", "Loading values...");
        model.addAttribute("cpuResult", resultadoJson.getCpu());
        model.addAttribute("escrituraDiscoResult", resultadoJson.getEscrituraDisco());
        model.addAttribute("lecturaDiscoResult", resultadoJson.getLecturaDisco());
        model.addAttribute("escrituraMemoriaResult", resultadoJson.getEscrituraMemoria());
        model.addAttribute("lecturaMemoriaResult", resultadoJson.getLecturaMemoria());
        model.addAttribute("bandwithResult", resultadoJson.getAnchoBanda());
        model.addAttribute("latencyResult", resultadoJson.getLatencia());
        model.addAttribute("instruccionesMinResult", resultadoJson.getInstruccionesMinuto());

        resultadoEjecucion.save(resultadoJson);

        return "chart";
    }

    /**
     * Devuelve un json con el historial de ejecuciones filtrado por servidor
     */
    @RequestMapping(value = "/getHistorialEjecuciones/{serverName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getHistorialEjecuciones(@PathVariable String serverName) {

        try {

            if (StringUtils.isEmpty(serverName)) {
                json = resultadoEjecucion.getAllResultadosEjecucion();
            } else {
                json = resultadoEjecucion.getAllResultadosEjecucion(serverName);
            }

            return (new ResponseEntity(json, getHpptHeader(), HttpStatus.OK));
        } catch (Exception e) {

            log.error("Se produjo un error al obtener el historial de ejecuciones: " + e.getMessage());

            return (new ResponseEntity(getErrorMessage("error", e.getMessage()), getHpptHeader(),
                    HttpStatus.BAD_REQUEST));
        }

    }

    /**
     * Devuelve un json con los resultados de la ultima ejecucion de los 3 proveedores
     */
    @RequestMapping(value = "/getUltimaEjecucion")
    @ResponseBody
    public ResponseEntity<String> getUltimaEjecucion() {

        try {
            json = resultadoEjecucion.getUltimaEjecucion();

            return (new ResponseEntity(json, getHpptHeader(), HttpStatus.OK));
        } catch (Exception e) {
            log.error("Se produjo un error al obtener los resultados de la comparación: " + e.getMessage());

            return (new ResponseEntity(getErrorMessage("error", e.getMessage()), getHpptHeader(),
                    HttpStatus.BAD_REQUEST));
        }

    }

    /**
     * Devuelve un json con los resultados de la ultima ejecucion de los 3 proveedores
     */
    @RequestMapping(value = "/getComparacion", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getComparacion() {

        try {
            json = resultadoEjecucion.getComparacion();

            return (new ResponseEntity(json, getHpptHeader(), HttpStatus.OK));
        } catch (Exception e) {
            log.error("Se produjo un error al obtener los resultados de la comparación: " + e.getMessage());

            return (new ResponseEntity(getErrorMessage("error", e.getMessage()), getHpptHeader(),
                    HttpStatus.BAD_REQUEST));
        }

    }

    @RequestMapping(value = "getAtributoByName/{atributo}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getAtributoByName(@PathVariable String atributo) {

        try {

            if (!StringUtils.isEmpty(atributo)) {
                json = resultadoEjecucion.getAtributoByName(atributo);
                return (new ResponseEntity(json, getHpptHeader(), HttpStatus.OK));
            } else {
                return (new ResponseEntity(
                        getErrorMessage("error", "No se encontro el atributo"), getHpptHeader(),
                        HttpStatus.BAD_REQUEST));
            }

        } catch (Exception e) {

            log.error("Se produjo un error al obtener el historial de ejecuciones: " + e.getMessage());

            return (new ResponseEntity(getErrorMessage("error", e.getMessage()), getHpptHeader(),
                    HttpStatus.BAD_REQUEST));
        }

    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleException(Exception exception) {
        log.error("Faltan parametros en la solicitud enviada: " + exception.getMessage());

        return (new ResponseEntity(getErrorMessage("error", exception.getMessage()),
                getHpptHeader(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "error";
    }

}
