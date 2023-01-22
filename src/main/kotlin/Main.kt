import io.github.cdimascio.dotenv.dotenv

fun main() {
    val dotenv = dotenv() {
        directory = "./"
    }
    val opts = ScrapeOpts(
        headless = dotenv["headless", "true"].toBoolean(),
        baseUrl = dotenv["baseurl"],
        username = dotenv["sarhatabaot"],
        password = dotenv["password"],
        forumBase = dotenv["forumbase"],
        allowThreads = dotenv["allowthreads"].replace("\"","").split(","),
        ignoreThreads = dotenv["ignorethreads"].replace("\"","").split(",")
    )
    //val rslt = scrape(opts)
    mkTables()
    scrape(opts)
    //writeForumsToFiles(rslt)
}