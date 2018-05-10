import java.net.URLEncoder

fun String.generateLmgtfy(engine: SearchEngine = SearchEngine.Google, type: SearchType = SearchType.Web, includeIE: Boolean = true): String {
    if (engine != SearchEngine.Google && type != SearchType.Web) {
        throw UnsupportedOperationException("${type.name} search is currently not supported by ${engine.name} through lgmtfy.")
    }
    val ieValue = if (includeIE) 1 else 0
    val searchQuery = URLEncoder.encode(this, "UTF-8")
    return "http://lmgtfy.com/?iie=$ieValue&s=${engine.key}&t=${type.key}&q=$searchQuery"
}
