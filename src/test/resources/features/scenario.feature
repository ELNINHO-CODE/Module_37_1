#Gherkin
Feature: Find restaurant
  #Позитивный сценарий: выбираем город краснодар и получем меню для краснодара
  Scenario: chose restaurant city
    Given url of restaurant 'https://dodopizza.ru/'
    Then  chose city 'Краснодар'
    And assert that chosen city is 'Краснодар'
  #Негатинвый сценарий: выбираем несушествующий город, получаем соответствуещее уведомление
  Scenario: chose absent city
    Given url of restaurant 'https://dodopizza.ru/'
    Then  chose city 'Лапландия'
    And assert that user got message 'Пиццерия в этом городе еще не открылась'