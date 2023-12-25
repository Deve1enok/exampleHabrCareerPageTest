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
<a href="https://www.atlassian.com/ru/software/jira/"><img width="5%" title="Jira" src="src/media/logo/Jira.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira/"><img width="5%" title="Jira" src="src/media/logo/JUnit5.svg"></a>
</p>

____
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
-  *Поиск работы c пустым полем и пустой сортировкой*
-  *Поиск работы "тестирование" c пустой сортировкой*
-  *Поиск работы \"тестирование\" с заполнением сортировки*
-  *Поиск работы c пустым полем и заполненной сортировкой*
-  *Поиск работы "тестирование" с заполнением сортировки и её сброса*

## <a name="Примеры ручных тест-кейсов">**Примеры ручных тест-кейсов:**</a>
-  *Смена языка интерфейса с русского на английский*
-  *Смена языка публикаций с русского на английский*
-  *Смена вида ленты с классического на компактный*
-  *Переход с ХабрКарьера на Хабр*
-  *Переход с ХабрКарьера на Q&A*
-  *Переход с ХабрКарьера на Фриланс*
-  *Переход с ХабрКарьера на Анонимный Дед Мороз*

____

<a id="console"></a>
## :keyboard: Запуск автотестов


***Локальный запуск тестов:***
```bash  
gradle clean test_suite
gradle clean positive_tests
gradle clean negative_tests
```
____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="src/media/logo/jenkins-original.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/portfolio_example_habr_career_jenkins_test/)</a>
### **Для запуска сборки необходимо перейти в раздел `Build with Parameters` выбрать нужные вам параметры и нажать кнопку `Build`.**
<p align="center">  
<img title="Jenkins" src="src/media/screenshots/jenkinsBuild.jpg" alt="Jenkins"/>
</p>
После выполнения сборки, в блоке <code>Build history</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.


<p align="center">   
<img title="JenkinsBuild" src="src/media/screenshots/historyJenkins.jpg" alt="Jenkins"/></a>
</p>

____

<a id="allure"></a>
## <img src="src/media/logo/jenkins-original.svg" width="25" height="25"  alt="Allure"/></a> Allure <a target="_blank" href="https://jenkins.autotests.cloud/job/portfolio_example_habr_career_jenkins_test/allure/">отчёт</a>

## *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="src/media/screenshots/allureReportMain.jpg">  
</p>  

## *Подробный отчёт одного из тест-кейсов*
### **На вкладке <code>Behaviors</code> можно рассмотреть каждый тест-кейс и его шаги воспроизведения, файлы(скриншоты,видео,код и т.п.).**
<p align="center">  
<img title="Allure Overview Dashboard" src="src/media/screenshots/allureReportsTK.jpg">  
</p>

____


<a id="allureTestOps"></a>
## <img alt="AllureTestOps" height="25" src="src/media/logo/Allure_TO.svg" width="25"/></a><a name="Интеграция AllureTO"></a>Интеграция с [AllureTestOps](https://allure.autotests.cloud/project/3884/dashboards)</a>
### **На `Dashboard` в `Allure TestOps` видна статистика тестирования: количество тест-кейсов, количество ручных/автоматизированных тестов, количество запусков тест-кейсов.**
<p align="center">  
<img title="AllureTestOps Dashboard" src="src/media/screenshots/allureTestOpsDashBoard.jpg">
</p>

Во вкладке <code>Test-cases</code> представлены все существующие тест-кейсы с подробным описанием, шагами воспроизведения, тегами, историей.

<p align="center">   
<img title="AllureTestOpsTS" src="src/media/screenshots/allureTestOpsTestSuite.jpg" alt="AllureTestOpsTs">
</p>

Каждый тест-кейс имеет интеграцию с <code>Jira</code>. При клике на линк, мы попадем на задачу тест-кейса в <code>Jira</code>.

<p align="center">   
<img title="AllureTestOpsTS" src="src/media/screenshots/allureTestOpsIssues.jpg" alt="AllureTestOpsIssues">
</p>


____


<a id="jiraTasks"></a>
## <img alt="jiraTask" height="25" src="src/media/logo/Jira.svg" width="25"/></a><a name="Интеграция Jira"></a>Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1010)</a>
### **Реализована интеграция `Allure TestOps` с `Jira`, в тикете отображается, какие тест-кейсы были написаны в рамках задачи и результат их прогона.**
<p align="center">  
<img title="Jira Tasks" src="src/media/screenshots/jiraMainTask.jpg">
</p>

____


## <img title="Telegram" width="25" height="25" src="src/media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота.
### **После завершения сборки <code>Telegram</code> бот, автоматически обрабатывает информацию и отправляет сообщение с отчетом о прогоне тестов.**

<p align="center">
<img title="Telegram Notifications" src="src/media/screenshots/telegramBotInfo.jpg">
</p>


____


## <img title="Selenoid" width="25" height="25" src="src/media/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid.
### **В отчетах <code>Allure</code> для каждого теста прикреплен не только скриншот, но и видео прохождения теста.**
<p align="center">
<img title="Selenoid Video" src="src/media/screenshots/videoTestHabrCareer.gif">
</p>
