/*
 * SUPLA Cloud API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 2.3.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package pl.grzeslowski.jsupla.api.generated.api;

import org.junit.Ignore;
import org.junit.Test;
import pl.grzeslowski.jsupla.api.generated.ApiException;
import pl.grzeslowski.jsupla.api.generated.model.AccessIdentifier;
import pl.grzeslowski.jsupla.api.generated.model.AccessIdentifierUpdateRequest;

import java.util.List;

/**
 * API tests for AccessIdentifiersApi
 */
@Ignore
public class AccessIdentifiersApiTest {

    private final AccessIdentifiersApi api = new AccessIdentifiersApi();

    /**
     * Create a new Access Identifier
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createAccessIdentifierTest() throws ApiException {
        AccessIdentifier response = api.createAccessIdentifier();

        // TODO: test validations
    }
    /**
     * Delete Access Identifier
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteAccessIdentifierTest() throws ApiException {
        Integer id = null;
        api.deleteAccessIdentifier(id);

        // TODO: test validations
    }
    /**
     * Get Access Identifier
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAccessIdentifierTest() throws ApiException {
        Integer id = null;
        List<String> include = null;
        AccessIdentifier response = api.getAccessIdentifier(id, include);

        // TODO: test validations
    }
    /**
     * Get Access Identifiers list
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAccessIdentifiersTest() throws ApiException {
        List<String> include = null;
        List<AccessIdentifier> response = api.getAccessIdentifiers(include);

        // TODO: test validations
    }
    /**
     * Update Access Identifier
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateAccessIdentifierTest() throws ApiException {
        AccessIdentifierUpdateRequest body = null;
        Integer id = null;
        AccessIdentifier response = api.updateAccessIdentifier(body, id);

        // TODO: test validations
    }
}
