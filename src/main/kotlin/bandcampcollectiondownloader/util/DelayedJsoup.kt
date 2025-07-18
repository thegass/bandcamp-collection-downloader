package bandcampcollectiondownloader.util

import org.jsoup.Connection
import org.jsoup.Jsoup
import java.util.concurrent.ThreadLocalRandom

object DelayedJsoup {

    @Throws(Exception::class)
    fun connectWithDelay(url: String, minDelay: Long, maxDelay: Long): Connection {
        if (maxDelay > minDelay) {
            // Generate a random delay between minDelay and maxDelay
            val delay = ThreadLocalRandom.current().nextLong(minDelay, maxDelay)
            Thread.sleep(delay)
        }
        // Return the Jsoup connection
        return Jsoup.connect(url)
    }
}