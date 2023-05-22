#example of executions:
Defined 2 groups of JUnit tests:
pl.programautomatycy.cart.service.test.categories.IntegrationTest
pl.programautomatycy.cart.service.test.categories.ImportantTest

Examples od execution with Dgroups command:
1.mvn test -Dgroups="pl.programautomatycy.cart.service.test.categories.IntegrationTest"

2.mvn test -Dgroups="pl.programautomatycy.cart.service.test.categories.IntegrationTest,pl.programautomatycy.cart.
service.test.ImportantTest"

3. mvn test -DexcludedGroups="pl.programautomatycy.cart.service.test.categories.ImportantTest"
