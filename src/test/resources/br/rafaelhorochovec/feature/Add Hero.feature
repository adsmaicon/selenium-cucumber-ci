#encoding: iso-8859-1
@add
Feature: Add heroes

	As a user
  I would like to register new heroes
  So I can get to know both universes

  Background: 
    Given I wish save a new hero
    When click in "Adicionar"

  Scenario Outline: Deve cadastrar um novo herói
    And insert "<nome>", "<nome_civil>" e "<universo>"
    And click in "Salvar"
    Then will present the message "<mensagem>"
    Examples:
    | nome 				| nome_civil | universo | mensagem 							 |
    | Super Homem | Clark Kent | DC 			| Novo herói adicionado! |
    
    
     