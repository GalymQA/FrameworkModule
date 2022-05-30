# Practical Task

Develop an automation framework for the Hardcore task in WebDriver.

### The final framework should include the following:

- A WebDriver manager for managing browser connectors
- Page Object/Page Factory for page abstractions
- Models for business objects of the required elements
- Property files with test data for at least two different environments
- XML suites for smoke test and other test
- If the test fails, a screenshot with the date and time is taken
- The framework should include an option for running with Jenkins and browser parameterization, test suite, environment
- Test results should be displayed on the job chart, and the screenshots should be archived as artifacts.

# Hardcore

При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page
Object. Автоматизировать следующий сценарий:

1. Открыть https://cloud.google.com/
2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска"Google Cloud Platform Pricing Calculator"
3. Запустить поиск, нажав кнопку поиска.
4. В результатах поиска кликнуть "Google Cloud Platform Pricing Calculator" и перейти на страницу калькулятора.
5. Активировать раздел COMPUTE ENGINE вверху страницы
6. Заполнить форму следующими данными:
    * Number of instances: 4
    * What are these instances for?: оставить пустым
    * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
    * VM Class: Regular
    * Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
    * Выбрать Add GPUs
        * Number of GPUs: 1
        * GPU type: NVIDIA Tesla V100
    * Local SSD: 2x375 Gb
    * Datacenter location: Frankfurt (europe-west3)
    * Commited usage: 1 Year
7. Нажать Add to Estimate
8. Выбрать пункт EMAIL ESTIMATE
9. В новой вкладке открыть https://yopmail.com/ или аналогичный сервис для генерации временных email'ов
10. Скопировать почтовый адрес сгенерированный в yopmail.com
11. Вернуться в калькулятор, в поле Email ввести адрес из предыдущего пункта
12. Нажать SEND EMAIL
13. Дождаться письма с рассчетом стоимости и проверить что Total Estimated Monthly Cost в письме совпадает с тем, что
    отображается в калькуляторе