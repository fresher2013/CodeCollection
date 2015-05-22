package com.miemie.utils;

public class DbQueryUtils {
    /**
     * Escape values to be used in LIKE sqlite clause.
     *
     * The LIKE clause has two special characters: '%' and '_'.  If either of these
     * characters need to be matched literally, then they must be escaped like so:
     *
     * WHERE value LIKE 'android\_%' ESCAPE '\'
     *
     * The ESCAPE clause is required and no default exists as the escape character in this context.
     * Since the escape character needs to be defined as part of the sql string, it must be
     * provided to this method so the escape characters match.
     *
     * @param sb The StringBuilder to append the escaped value to.
     * @param value The value to be escaped.
     * @param escapeChar The escape character to be defined in the sql ESCAPE clause.
     */
    public static void escapeLikeValue(StringBuilder sb, String value, char escapeChar) {
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (ch == '%' || ch == '_') {
                sb.append(escapeChar);
            }
            sb.append(ch);
        }
    }
    
    /**
     * Appends an SQL string to the given StringBuilder, including the opening
     * and closing single quotes. Any single quotes internal to sqlString will
     * be escaped.
     *
     * This method is deprecated because we want to encourage everyone
     * to use the "?" binding form.  However, when implementing a
     * ContentProvider, one may want to add WHERE clauses that were
     * not provided by the caller.  Since "?" is a positional form,
     * using it in this case could break the caller because the
     * indexes would be shifted to accomodate the ContentProvider's
     * internal bindings.  In that case, it may be necessary to
     * construct a WHERE clause manually.  This method is useful for
     * those cases.
     *
     * @param sb the StringBuilder that the SQL string will be appended to
     * @param sqlString the raw string to be appended, which may contain single
     *                  quotes
     */
    public static void appendEscapedSQLString(StringBuilder sb, String sqlString) {
        sb.append('\'');
        if (sqlString.indexOf('\'') != -1) {
            int length = sqlString.length();
            for (int i = 0; i < length; i++) {
                char c = sqlString.charAt(i);
                if (c == '\'') {
                    sb.append('\'');
                }
                sb.append(c);
            }
        } else
            sb.append(sqlString);
        sb.append('\'');
    }
}
