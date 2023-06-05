[![Medium Web Framework](/docs/medium-web-framework.png)]()

## Cucumber BDD Framework with Selenium, TestNG and Java

Si vous souhaitez tester une application web de préférence, un ecommerce alors ce framework est pour vous.
Il contient plusieurs modèles et bonnes pratiques comme le `Page Object Model`, le `Page Factory`, le `Single Responsibility` et le `DRY (Do Not Repeat Yourself)` qui vous permettent d'avoir un framework assez robuste, réutilisable et maintenable.

### Sommaire:

🏷️ [Fonctionnalités](#fonctionnalités)<br/>
🏷️ [Librairies utilisées](#librairies-utilisées)<br/>
🏷️ [Prérequis avant installation](#prérequis-avant-installation)<br/>
🏷️ [Structure du framework](#structure-du-framework)<br/>
🏷️ [Comment installer le framework](#comment-installer-le-framework)<br/>
🏷️ [Comment exécuter le framework](#comment-exécuter-le-framework)<br/>
🏷️ [Comment consulter les rapports](#comment-consulter-les-rapports)<br/>
🏷️ [Comment fonctionne le framework](#comment-fonctionne-le-framework)<br/>
🏷️ [Comment maintenir le framework](#maintenance-du-framework)<br/>
🏷️ [Comment déboguer le framework](#comment-déboguer-le-framework)<br/>

### 🎯Fonctionnalités
✅ Java<br/>
✅ Selenium 4<br/>
✅Cucumber BDD (Features + Step Definitions)<br/>
✅ Data Driven Testing<br/>
✅ Domain Object<br/>
✅ Page Object Model<br/>
✅ Page Factory<br/>
✅ Cucumber Report<br/>
✅ Spark Extent Report<br/>
✅ Master Thought Report <br/>
✅ Screenshot<br/>
✅ Rest Assured<br/>
✅ Execution Parallèle (PicoContainer)<br/>
✅ Intégration with GitHub<br/><br/>

  [![My Skills](https://skillicons.dev/icons?i=java,selenium,gherkin,idea)](https://skillicons.dev)

### 🎯Librairies Utilisées

1️⃣ Java<br/>
2️⃣ Maven<br/>
3️⃣ Cucumber<br/>
4️⃣ Selenium WebDriver<br/>
5️⃣ WebDriverManager<br/>
6️⃣ Cucumber Report<br/>
7️⃣ Extent Spark  Report<br/>
8️⃣ Masterthought Report<br/>

### 🎯Prérequis avant installation
   
``` bash
 🔴#JAVA 11 [Mac]
  🔹Télécharger et installer Java sur votre machine (Voir lien de téléchargement⬇️).
  🔹Configurer java home: export JAVA_HOME = /Library/Java/Home
```

``` bash
  🔴#Maven 3.8.6  [Mac]
  🔹Installer sur Mac à partir du terminal: brew install maven
  🔹Configurer les variables d'environment:
      export M2_HOME=/usr/local/apache-maven/apache-maven-3.8.4 
      export M2 = $M2_HOME/bin
      export MAVEN_OPTS = -Xms256m -Xmx512m
```
Liens de téléchargement :<br/>
⚓Téléchargez et Installez Maven sur [Windows](https://maven.apache.org/download.cgi)<br/>
⚓Téléchargez et Installez Java sur [Mac](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE) ou [Windows](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA)<br/>

### 🎯Structure du framework

```
📦MediumWebFramework
┣ 📂docs
┣ 📂src
┃ ┣ 📂test
┃ ┃ ┣ 📂java
┃ ┃ ┃ ┗ 📂bdd
┃ ┃ ┃ ┃ ┗ 📂automation
┃ ┃ ┃ ┃ ┃ ┣ 📂apis
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ApiRequest.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CartApi.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SpecBuilder.java
┃ ┃ ┃ ┃ ┃ ┣ 📂constants
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EndPoint.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EnvType.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyConstants.java
┃ ┃ ┃ ┃ ┃ ┣ 📂context
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TestContext.java
┃ ┃ ┃ ┃ ┃ ┣ 📂customtype
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CustomDataTableType.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CustomParameterType.java
┃ ┃ ┃ ┃ ┃ ┣ 📂domainobjects
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BillingDetails.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Cookies.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Product.java
┃ ┃ ┃ ┃ ┃ ┣ 📂factory
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DriverFactory.java
┃ ┃ ┃ ┃ ┃ ┣ 📂hooks
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyHooks.java
┃ ┃ ┃ ┃ ┃ ┣ 📂pages
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜BasePage.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CartPage.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CheckoutPage.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PageFactoryManager.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StorePage.java
┃ ┃ ┃ ┃ ┃ ┣ 📂runners
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜FailedRunnerTest.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TestNGRunnerTest.java
┃ ┃ ┃ ┃ ┃ ┣ 📂steps
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CartStep.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CheckoutStep.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CustomerSteps.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StepDef.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StoreStep.java
┃ ┃ ┃ ┃ ┃ ┣ 📂utils
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ConfigLoader.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CookieUtils.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PropertyUtils.java
┃ ┃ ┣ 📂resources
┃ ┃ ┃ ┗ 📂bdd
┃ ┃ ┃ ┃ ┗ 📂automation
┃ ┃ ┃ ┃ ┃ ┣ 📂features
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📒add_to_cart.feature
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📒guest_place_an_order.feature
┃ ┃ ┣ 📑cucumber.properties
┃ ┃ ┣ 📑extent.properties
┃ ┃ ┣ 🗒️pdf-config.yaml
┃ ┃ ┣ 📑prod_config.properties
┃ ┃ ┣ 📃spark-config.xml
┃ ┃ ┣ 📑stage_config.properties
┣ 💼target
┃ ┣ 📂cucumber-reports
┃ ┃ ┣📄cucumber.html
┃ ┃ ┣🧾cucumber.json
┃ ┃ ┣📃️cucumber.xml
┣🧰test-output
┃ ┣ 📂ExtentReport
┃ ┃ ┣ 📂SparkReport
┃ ┃ ┃ ┣📄cucumber.html
┃ ┃ ┃ ┣📋cucumber.pdf
```

### 🎯Comment installer le framework

``` bash
  📌 Après avoir téléchargé et installé Java, Maven, maintenant installez le projet suivant ces étapes:
    🔸Dans le terminal, saisissez: ➡️ git clone lien-repo-gitlab-du-framework.git
    🔸Ouvrez le projet dans votre IDE, faîtes un ⚠️build et exécutez-le.
```

### 🎯Comment exécuter le framework

Ce framework exécute les tests en parallèle sur le navigateur ⚠️chrome, ⚠️firefox, ⚠️ edge ou⚠️ safari de plusieurs façons:<br/>

``` bash
 📌Fichier java: Exécute en parallèle, les tests sur ️chrome: 
    🔸Classe: TestNGRunnerTest.java
    ➡️src/test/java/bdd/automation/runners
 ```

``` bash
 📌[terminal] Exécute  en parallèle, les tests sur ️chrome:
    ➡️cd chemin-du-projet/framework
  🔸mvn clean test
```

``` bash
 📌[terminal] Exécuter les tests en parallèle sur différents navigateurs:
    ➡️cd chemin-du-projet/framework
  🔸mvn clean test -Dbrowser=firefox
  🔸mvn clean test -Dbrowser=edge
  🔸mvn clean test -Dbrowser=chrome
```

``` bash
 📌[terminal] Exécuter en parallèle, les tests sur différents environnements:
    ➡️cd chemin-du-projet/framework
  🔸mvn clean test -DEnv=STAGE {environnement par défaut}
  🔸mvn clean test -DEnv=PROD
```

``` bash
 📌[terminal] Exécuter les tests en parallèle sur différents navigateurs et différents environnements:
    ➡️cd chemin-du-projet/framework
  🔸mvn clean test -Denv=STAGE -Dbrowser=edge
  🔸mvn clean test -Denv=STAGE -Dbrowser=chrome
  🔸mvn clean test -Denv=STAGE -Dbrowser=firefox
```

``` bash
 📌[terminal] Exécuter  les tests à partir des tags de Cucumber:
    ➡️cd chemin-du-projet/framework
  🔸mvn test -Dcucumber.options="--tags @Smoke or @Regression"
    ↪️ Exécute  en parallèle tous les tests
  🔸mvn test -Dcucumber.filter.tags="@Smoke"
    ↪️ Exécute  en parallèle tous les scenarios du feature {add_to_cart}
  🔸mvn test -Dcucumber.filter.tags="@Regression"
    ↪️ Exécute  en parallèle tous les scenarios du feature {guest_place_an_order}
```

### 🎯Comment consulter les rapports

+ Dans le repertoire ⚠️target :
``` bash
📌Html Report
  ➡️ /target/cucumber/cucumber.html
```

``` bash
📌Cucumber Report ⬇️
```
  [![cucumber_report](/docs/cucumber report.png)]()

``` bash
📌Extent Report
  ➡️ test-output/ExtentReport/SparkReport/ExtentReport.html
  ➡️ test-output/ExtentReport/SparkReport/ExtentReport.pdf 
```

### 🎯Comment fonctionne le framework
+ Ce framework vous permet d'effectuer des tests d'interface Utilisateurs (UI) sur une application web d'ecommerce [AskOmDch](https://askomdch.com/store/), les scenarios exécutés ici sont les suivants: <br/><br/>
  ✴️ Ajouter un produit au panier
   ```
   je veux accéder à la page web `https://askomdch.com/store
   Je veux ajouter un produit (Blue Shoes) au panier
   Puis je vois le produit ajouté dans le panier
   ```
  ✴️ Commander un produit
  ```
  En tant qu'un visiteur du site
  J'ajoute un produit au panier
  Je vais à la page de vérification
  je saisis mes données de carte bancaire
  Je passe la commande de mon produit
  Ma commande est effectuée avec succès
  ```
<br/>

#### 🛠️Création d'un test
1) Rédaction du scénario
+ Dans le repertoire ⚠️Features, ouvrir le feature file correspondant au scénario que l'on veut rajouter.
 ```
  📌features
   🔸add_to_cart: rajouter des scénarios pour l'ajout d'un produit au panier
   🔸guest_place_an_order: rajouter des scénarios pour procéder au paiement d'un produit
 ```

+  Rédiger le scénario en Gherkin, comme suit :
```     
  📌Example
    🔸Scenario: Add one quantity from Store
        Given I'm on the Store Page
        When I add a "Blue Shoes" to the cart
        Then I should see 1 "Blue Shoet" in the cart
```
<br/>

2) création des "step definition"  

```
  📌Solution 1:  
    Lancer un run du feature file :  
    🔸un squelette des étapes manquantes s'affichera dans la console, ajoutez ces fonctions au "StepDef".
    
  📌Solution 2:  
    Utiliser l'assistant intelligent de l'éditeur de code :  
    🔸Préciser l'intitulé du fichier ou les "step definition" seront générés.
```
<br/>

3) Rédaction des fonctions objets

+ Dans ce framework, nous utilisons le modèle ⚠️Page Object et ⚠️ Page Factory avec les classes suivants :

```
 🔸 StorePage.java 
    ➡️ /src/test/java/bdd/automation/pages/StorePage.java
 🔸 CartPage.java 
    ➡️ /src/test/java/bdd/automation/pages/CartPage.java
 🔸 CheckoutPage.java
    ➡️ /src/test/java/bdd/automation/pages/CheckoutPage.java
 🔸 BasePage.java
    ➡️ /src/test/java/bdd/automation/pages/BasePage.java
```
<br/>

4) Intégration des fonctions objets aux steps definitions

```
 📌Ouvrir le repertoire "steps" et ouvrir le fichier "StepDef.java"
 ➡️src/test/java/bdd/automation/steps
```

### 🎯Comment maintenir le framework
```
 📌Pour la maintenance de ce framework, vous pouvez modifier le navigateur et lancer les tests sur les navigateurs Firefox ou Edge.
 ➡️src/test/java/bdd/automation/factory/DriverFactory.java.
 
 📌Vous pouvez aussi ajouter des scénarios et exécuter vos propres tests.
 ➡️src/test/resources/bdd.automation/features
```

### 🎯Comment déboguer le framework
Pour déboguer le framework, vous pouvez faire :
```
 📌build project
 🔸mvn clean
 🔸Run ➡️ build project
```
