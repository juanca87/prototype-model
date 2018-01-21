/*
 * MIT License
 *
 * Copyright (c) 2018 JUAN CALVOPINA M
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

package com.jcalvopinam.api.web;

import com.jcalvopinam.api.measures.InfoServidor;
import com.jcalvopinam.api.model.ResultadoEjecucion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;

import static com.jcalvopinam.api.web.HomeControllerTest.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Juan Calvopina M. <juan.calvopina@gmail.com>
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ResultadoEjecucionController.class, secure = false)
public class ResultadoEjecucionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ResultadoEjecucionController resultadoEjecucionController;

    @Test
    public void getResultadoEjecucionMockup() throws Exception {
        String serverName = "test";
        ResultadoEjecucion resultadoEjecucion = this.buildResultadoEjecucion(serverName);

        when(resultadoEjecucionController.getResultadoEjecucionMockup(serverName)).thenReturn(resultadoEjecucion);

        String url = "/getResultadoEjecucionMockup/" + serverName;

        MvcResult mvcResult = mockMvc.perform(get(url).header(ACCESS_CONTROL_REQUEST_METHOD, GET)
                                                      .header(ORIGIN, HOST))
                                     .andReturn();

        String resultado = mvcResult.getResponse().getContentAsString();
        assertNotNull(resultado);
        assertEquals(serverName, resultadoEjecucion.getServidor());
    }

    @Test
    public void getResultadoEjecucion() throws Exception {
        String serverName = "test";
        ResultadoEjecucion resultadoEjecucion = this.buildResultadoEjecucion(serverName);

        when(resultadoEjecucionController.getResultadoEjecucionMockup(serverName)).thenReturn(resultadoEjecucion);

        String url = "/getResultadoEjecucion/" + serverName;

        MvcResult mvcResult = mockMvc.perform(get(url).header(ACCESS_CONTROL_REQUEST_METHOD, GET)
                                                      .header(ORIGIN, HOST))
                                     .andReturn();

        String resultado = mvcResult.getResponse().getContentAsString();
        assertNotNull(resultado);
        assertEquals(serverName, resultadoEjecucion.getServidor());
    }

    @Test
    public void getInfoServidor() throws Exception {
        InfoServidor infoServidor = this.buildInfoServidor();

        when(resultadoEjecucionController.getInfoServidor()).thenReturn(infoServidor);

        MvcResult mvcResult = mockMvc.perform(get("/infoServidor/").header(ACCESS_CONTROL_REQUEST_METHOD, GET)
                                                                   .header(ORIGIN, HOST))
                                     .andReturn();

        String resultado = mvcResult.getResponse().getContentAsString();
        assertNotNull(resultado);
        assertEquals("Darwin", infoServidor.getSistemaOperativo());
    }

    private InfoServidor buildInfoServidor() {
        InfoServidor infoServidor = new InfoServidor();
        infoServidor.setArquitectura("x86");
        infoServidor.setCpu("2.0");
        infoServidor.setSistemaOperativo("Darwin");
        infoServidor.setTotalDisco("200");
        infoServidor.setTotalRAM("16");
        infoServidor.setVersion("1");
        return infoServidor;
    }

    private ResultadoEjecucion buildResultadoEjecucion(String serverName) {
        ResultadoEjecucion resultadoEjecucion = new ResultadoEjecucion();
        resultadoEjecucion.setAnchoBanda("9.242");
        resultadoEjecucion.setCpu("12000");
        resultadoEjecucion.setEscrituraDisco("24100");
        resultadoEjecucion.setEscrituraMemoria("23115");
        resultadoEjecucion.setInstruccionesMinuto("14127");
        resultadoEjecucion.setLatencia("10123");
        resultadoEjecucion.setLecturaDisco("20345");
        resultadoEjecucion.setLecturaMemoria("38488");
        resultadoEjecucion.setFecha(new Date());
        resultadoEjecucion.setServidor(serverName);
        return resultadoEjecucion;
    }

}