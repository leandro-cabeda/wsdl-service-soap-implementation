//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.02.12 às 04:34:58 PM GMT-03:00 
//


package com.wsservice.users;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wsservice.users package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wsservice.users
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllUsersResponse }
     * 
     */
    public GetAllUsersResponse createGetAllUsersResponse() {
        return new GetAllUsersResponse();
    }

    /**
     * Create an instance of {@link Users }
     * 
     */
    public Users createUsers() {
        return new Users();
    }

    /**
     * Create an instance of {@link DeleteUsersResponse }
     * 
     */
    public DeleteUsersResponse createDeleteUsersResponse() {
        return new DeleteUsersResponse();
    }

    /**
     * Create an instance of {@link GetUsersResponse }
     * 
     */
    public GetUsersResponse createGetUsersResponse() {
        return new GetUsersResponse();
    }

    /**
     * Create an instance of {@link SaveOrUpdateUsersRequest }
     * 
     */
    public SaveOrUpdateUsersRequest createSaveOrUpdateUsersRequest() {
        return new SaveOrUpdateUsersRequest();
    }

    /**
     * Create an instance of {@link SaveOrUpdateUsersResponse }
     * 
     */
    public SaveOrUpdateUsersResponse createSaveOrUpdateUsersResponse() {
        return new SaveOrUpdateUsersResponse();
    }

    /**
     * Create an instance of {@link GetAllUsersRequest }
     * 
     */
    public GetAllUsersRequest createGetAllUsersRequest() {
        return new GetAllUsersRequest();
    }

    /**
     * Create an instance of {@link DeleteUsersRequest }
     * 
     */
    public DeleteUsersRequest createDeleteUsersRequest() {
        return new DeleteUsersRequest();
    }

    /**
     * Create an instance of {@link GetUsersRequest }
     * 
     */
    public GetUsersRequest createGetUsersRequest() {
        return new GetUsersRequest();
    }

}
