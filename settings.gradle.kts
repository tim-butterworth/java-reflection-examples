rootProject.name = "demo"

include("examples")
project(":examples").projectDir = file("applications/examples")

include("forClassLoading")
project(":forClassLoading").projectDir = file("applications/forClassLoading")

include("greatIdeaInterfaces")
project(":greatIdeaInterfaces").projectDir = file("applications/interfaceAndImpl/greatIdeaInterfaces")

include("highQualityIdeas")
project(":highQualityIdeas").projectDir = file("applications/interfaceAndImpl/highQualityIdeas")

include("lowBudgetIdeas")
project(":lowBudgetIdeas").projectDir = file("applications/interfaceAndImpl/lowBudgetIdeas")