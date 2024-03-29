# Проект по автоматизации тестирования для [ХабрКарьера](https://career.habr.com/)

<img alt="habrCareer" src="media/screenshots/habrCareerMainPage.jpg">


## :clipboard: Содержание:
* <a href="#tools">Используемый стек</a>
* <a href="#cases">Примеры автоматизированных тест-кейсов</a>
* <a href="#console">Запуск из терминала</a>
* <a href="#jenkins">Сборка в Jenkins</a>
* <a href="#allure">Allure отчет</a>
* <a href="#allureTestOps">Интеграция с AllureTestOps</a>
* <a href="#jira">Интеграция с Jira</a>
* <a href="#telegram">Интеграция с Telegram ботом</a>
* <a href="#selenoid">Видеозапись тестов с Selenoid</a>


____
<a id="tools"></a>
## :computer: <a name="Используемый стек">**Используемый стек:**</a>

<p align="center">
<a href="https://www.java.com/"><img height= "40" width="40" title="Java" src="media/logo/java-original.svg"></a>
<a href="https://selenide.org/"><img height= "40" width="40" title="Selenide" src="media/logo/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img height= "40" width="40" title="Selenoid" src="media/logo/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img height= "40" width="40" title="Allure Report" src="media/logo/Allure.svg"></a>
<a href="https://qameta.io/"><img height= "40" width="40" title="Allure TestOps" src="media/logo/Allure_TO.svg"></a>
<a href="https://gradle.org/"><img height= "40" width="40" title="Gradle" src="media/logo/gradle-plain-wordmark.svg"></a>
<a href="https://github.com/"><img height= "40" width="40" title="GitHub" src="media/logo/github-original-wordmark.svg"></a>
<a href="https://www.jenkins.io/"><img height= "40" width="40" title="Jenkins" src="media/logo/jenkins-original.svg"></a>
<a href="https://web.telegram.org/a/"><img height= "40" width="40" title="Telegram" src="media/logo/Telegram.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira/"><img height= "40" width="40" title="Jira" src="media/logo/Jira.svg"></a>
<a href="https://junit.org/junit5/"><img height= "40" width="40" title="JUnit5" src="media/logo/JUnit5.svg"></a>
<a href="https://www.jetbrains.com/ru-ru/idea/"><img height= "40" width="40" title="IDEA" src="media/logo/Idea.svg"></a>

В проекте средой разработки выступает `IntelliJIDEA`. Сборщик библиотек и плагинов `Gradle`, к которому мы подключили `Java`, `JUnit5`, `Selenide`, **Allure**, `JavaFaker`. Автотесты были написаны на языке `Java` с помощью инструмента автоматического управления браузером `Selenide`. В качестве отчетности о выполнении тестов выступает `Allure`, а `JavaFaker` - служит для создания фейковых данных.
Все тесты проходили на удаленном сервере `Selenoid`, а для удаленного запуска тестов использовался `Jenkins`,к которому мы подключили `AllureTestOps` для сбора статистики о тестах, `Jira` для создания тикетов, и бота с отчетом в `Telegram`. 

</p>

____
<a id="cases"></a>
## :pushpin: <a name="Примеры тест-кейсов">**Примеры тест-кейсов:**</a>
**Автоматизированные тест-кейсы на форму поиска для соискателей:**
-  Поиск работы c пустым полем поиска и сортировкой
-  Поиск работы с заполнением поля поиска и пустой сортировкой
-  Поиск работы с заполнением поля поиска и сортировки
-  Поиск работы c пустым полем и заполненной сортировкой
-  Поиск работы с заполнением поля поиска и сортировки с последующим сбросом сортировки

**Автоматизированные тест-кейсы на форму поиска для работодателей:**
-  Поиск специалистов c пустым полем поиска и сортировкой
-  Поиск специалистов с заполнением поля поиска и пустой сортировкой
-  Поиск специалистов с заполнением поля поиска и сортировки
-  Поиск специалистов c пустым полем и заполненной сортировкой
-  Поиск специалистов с заполнением поля поиска и сортировки с последующим сбросом сортировки

**Ручные тест-кейсы:**
-  Смена языка интерфейса с русского на английский
-  Смена языка публикаций с русского на английский
-  Смена вида ленты с классического на компактный
-  Переход с ХабрКарьера на Хабр
-  Переход с ХабрКарьера на Q&A
-  Переход с ХабрКарьера на Фриланс
-  Переход с ХабрКарьера на Анонимный Дед Мороз

____

<a id="console"></a>
## :keyboard: Запуск автотестов


Локальный запуск тестов:
```bash  
gradle clean test_suite
gradle clean positive_tests
gradle clean negative_tests
```
____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="media/logo/jenkins-original.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/portfolio_example_habr_career_jenkins_test/)</a>
Для запуска сборки необходимо перейти в раздел `Build with Parameters` и выбрать нужные вам параметры и нажать кнопку `Build`.
<p align="center">  
<img title="Jenkins" src="media/screenshots/jenkinsBuild.jpg" alt="Jenkins"/>
</p>
После выполнения сборки, в блоке <code>Build history</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.


<p align="center">   
<img title="JenkinsBuild" src="media/screenshots/historyJenkins.jpg" alt="Jenkins"/></a>
</p>

____

<a id="allure"></a>
## <img src="media/logo/Allure.svg" height= "25" width="25"  alt="Allure"/> Allure <a target="_blank" href="https://jenkins.autotests.cloud/job/portfolio_example_habr_career_jenkins_test/allure/">отчёт</a>

Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/screenshots/allureReportMain.jpg">  
</p>  

Подробный отчёт одного из тест-кейсов. На вкладке <code>Behaviors</code> можно рассмотреть каждый тест-кейс и его шаги воспроизведения, файлы(скриншоты,видео,код и т.п.).
<p align="center">  
<img title="Allure Overview Dashboard" src="media/screenshots/allureReportsTK.jpg">  
</p>

____


<a id="allureTestOps"></a>
## <img alt="AllureTestOps" src="media/logo/Allure_TO.svg" height= "25" width="25" /><a name="Интеграция AllureTO"></a>Интеграция с [AllureTestOps](https://allure.autotests.cloud/project/3884/dashboards)</a>
На `Dashboard` в `Allure TestOps` видна статистика тестирования: количество тест-кейсов, количество ручных/автоматизированных тестов, количество запусков тест-кейсов.
<p align="center">  
<img title="AllureTestOps Dashboard" src="media/screenshots/allureTestOpsDashBoard.jpg">
</p>

Во вкладке <code>Test-cases</code> представлены все существующие тест-кейсы с подробным описанием, шагами воспроизведения, тегами, историей.

<p align="center">   
<img title="AllureTestOpsTS" src="media/screenshots/allureTestOpsTestSuite.jpg" alt="AllureTestOpsTs">
</p>

Каждый тест-кейс имеет интеграцию с <code>Jira</code>. При клике на линк, мы попадем на задачу тест-кейса в <code>Jira</code>.

<p align="center">   
<img title="AllureTestOpsTS" src="media/screenshots/allureTestOpsIssues.jpg" alt="AllureTestOpsIssues">
</p>


____


<a id="jira"></a>
## <img alt="jiraTask" src="media/logo/Jira.svg" height= "25" width="25"/><a name="Интеграция Jira"></a>Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1010)</a>
Реализована интеграция `Allure TestOps` с `Jira`, в тикете отображается, какие тест-кейсы были написаны в рамках задачи и результат их прогона.
<p align="center">  
<img title="Jira Tasks" src="media/screenshots/jiraTask.jpg">
</p>

____

<a id="telegram"></a>
## <img title="Telegram" width="25" height="25" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота.
После завершения сборки <code>Telegram</code> бот, автоматически обрабатывает информацию и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="Telegram Notifications" src="media/screenshots/telegramBotInfo.jpg">
</p>


____

<a id="selenoid"></a>
## <img title="Selenoid" width="25" height="25" src="media/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid.
В отчетах <code>Allure</code> для каждого теста прикреплен не только скриншот, но и видео прохождения теста.
<p align="center">
<img title="Selenoid Video" src="media/screenshots/videoTestHabr.gif">
</p>
