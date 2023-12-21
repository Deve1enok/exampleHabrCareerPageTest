
# Проект по автоматизации тестирования для [ХабрКарьера](https://career.habr.com/)

<img alt="habrCareer" src="src/media/screenshots/habrCareerMainPage.jpg">


## :clipboard: Содержание:
* <a href="#tools">Используемый стек</a>
* <a href="#cases">Примеры автоматизированных тест-кейсов</a>
* <a href="#console">Запуск из терминала</a>
* <a href="#jenkins">Сборка в Jenkins</a>
* <a href="#allure">Allure отчет</a>


____
<a id="tools"></a>
## :computer:<a name="Используемый стек">**Используемый стек:**</a>

<p align="center">
<a href="https://www.java.com/"><img width="6%" title="Java" src="src/media/logo/java-original.svg"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="src/media/logo/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="src/media/logo/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="src/media/logo/Allure.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="src/media/logo/Allure_TO.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="src/media/logo/gradle-plain-wordmark.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="src/media/logo/github-original-wordmark.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="src/media/logo/jenkins-original.svg"></a>
<a href="https://web.telegram.org/a/"><img width="6%" title="Telegram" src="src/media/logo/Telegram.svg"></a>
<!-- <a href="https://www.atlassian.com/ru/software/jira/"><img width="5%" title="Jira" src="src/media/logo/Jira.svg"></a> -->
</p>

____
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
____
-  *Поиск работы c пустым полем и пустой сортировкой*
-  *Поиск работы "тестирование" c пустой сортировкой*
-  *Поиск работы \"тестирование\" с заполнением сортировки*
-  *Поиск работы c пустым полем и заполненной сортировкой*
-  *Поиск работы "тестирование" с заполнением сортировки и её сброса*


<a id="console"></a>
## :keyboard: Запуск автотестов

***Локальный запуск тестов:***
```bash  
gradle clean test_suite
```
____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="src/media/logo/jenkins-original.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/portfolio_example_habr_career_jenkins_test/)</a>
## <a name="Удаленный запуск автотестов">**Для запуска сборки необходимо перейти в раздел `Build with Parameters` выбрать нужные вам параметры и нажать кнопку `Build`.**</a>
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/portfolio_example_habr_career_jenkins_test/"><img src="src/media/screenshots/jenkinsAutoTest.jpg" alt="Jenkins"/></a>  
</p>

<a id="allure"></a>
## <img src="src/media/logo/jenkins-original.svg" width="25" height="25"  alt="Allure"/></a> Allure <a target="_blank" href="https://jenkins.autotests.cloud/job/portfolio_example_habr_career_jenkins_test/allure/">отчёт</a>

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="src/media/screenshots/allureReportMain.jpg">  
</p>  

### *Подробный отчёт одного из тест-кейсов*

<p align="center">  
<img title="Allure Overview Dashboard" src="src/media/screenshots/allureReportsTK.jpg">  
</p>  
