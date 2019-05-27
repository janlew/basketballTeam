<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
              <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
            </head>
            <body>
                <div class="container">
                    <h1><xsl:value-of select="druzyna/nazwa"></xsl:value-of></h1>
                    <h2><tr>Konferencja: </tr><xsl:value-of select="druzyna/konferencja"></xsl:value-of></h2>
                    <h3><tr>Właściciel: </tr><xsl:value-of select="druzyna/wlasciciel/imie"/>&#160; 
                    <xsl:value-of select="druzyna/wlasciciel/nazwisko"/></h3>
                    <h3><tr>Trener: </tr><xsl:value-of select="druzyna/trener/imie"/>&#160;
                    <xsl:value-of select="druzyna/trener/nazwisko"/></h3>

                    <h4><tr>Stadion: </tr><xsl:value-of select="druzyna/stadion/nazwaS"/>&#160;</h4>
                    <h5><tr>pojemność: </tr><xsl:value-of select="druzyna/stadion/pojemnosc"/>&#160;
                    <xsl:value-of select="druzyna/stadion/pojemnosc/@jednostka"/></h5>
                    
                    <table class="table table-stripped">
                        <thead>
                            <tbody>
                                <tr>
                                    <th>Pozycja</th>
                                    <th>Skrót</th>
                                </tr>
                                <xsl:for-each select="druzyna/pozycje/pozycja">
                                    <tr>
                                        <td><xsl:value-of select="nazwaP"/></td>
                                        <td><xsl:value-of select="@pos_id"/></td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>
                        </thead>
                    </table>

                    <h3>Zawodnicy: </h3>
                    <table class="table table-stripped">
                        <thead>
                            <tbody>
                                <tr>
                                    <th>Imie</th>
                                    <th>Nazwisko</th>
                                    <th>Pozycja</th>
                                    <th>Wzrost</th>
                                    <th>Numer</th>
                                    <th>Pochodzenie</th>
                                </tr>
                                <xsl:for-each select="druzyna/zawodnicy/zawodnik">
                                    <tr>
                                        <td><xsl:value-of select="imie"/></td>
                                        <td><xsl:value-of select="nazwisko"/></td>
                                        <td><xsl:value-of select="pozycja_zawodnika/@refid"/></td>
                                        <td><xsl:value-of select="wzrost"/>
                                        &#160;<xsl:value-of select="wzrost/@jednostka"/></td>
                                        <td><xsl:value-of select="numer"/></td>
                                        <td><xsl:value-of select="pochodzenie"/></td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>
                        </thead>
                    </table>

                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>