package com.demo.da.response;

public class PersonaResponseRest extends ResponseRest{

    private PersonaResponse personaResponse = new PersonaResponse();

    public PersonaResponse getPersonaResponse() {
        return personaResponse;
    }

    public void setPersonaResponse(PersonaResponse personaResponse) {
        this.personaResponse = personaResponse;
    }
}
