package com.ildreamteamjsx.azzurrinet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.ildreamteamjsx.azzurrinet.R.id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    Team[] teams = {
        //SERIE A
        new Team("Atalanta", "https://www.atalanta.it/", R.drawable.atalanta, "Bergamo, Lombardia", "#212121", "L'Atalanta, fondata nel 1907, è emersa come una forza crescente negli ultimi anni. Con uno stile di gioco offensivo, l'Atalanta ha raggiunto notevoli successi in Serie A e ha impressionato nelle competizioni europee."),
        new Team("Bologna", "https://www.bolognafc.it/", R.drawable.bologna, "Bologna, Emilia Romagna", "#04098c", "Fondata nel 1909, il Bologna ha una lunga storia nel calcio italiano. Ha vinto numerosi titoli di Serie A nel corso degli anni e ha contribuito a plasmare la storia del calcio italiano."),
        new Team("Cagliari", "https://www.cagliaricalcio.com/", R.drawable.cagliari, "Cagliari, Sardegna", "#c40202", "Il Cagliari, fondato nel 1920, ha avuto momenti di successo nel calcio italiano. Ha vinto uno scudetto negli anni '70 e ha mantenuto una presenza costante in Serie A."),
        new Team("Empoli", "https://empolifc.com/", R.drawable.empoli, "Firenze, Toscana", "#f5f5f5", "L'Empoli è una squadra che ha spesso alternato la sua presenza tra Serie A e Serie B. Fondata nel 1920, ha conosciuto periodi di successo e ha contribuito allo sviluppo di giovani talenti. La sua filosofia di gioco attraente ha ottenuto riconoscimento negli ultimi anni."),
        new Team("Fiorentina", "https://www.acffiorentina.com/it", R.drawable.fiorentina, "Firenze, Toscana", "#d400f0", "La Fiorentina è un club storico con una base di tifosi appassionati. Ha vinto uno scudetto negli anni '50 e ha avuto successo anche nelle competizioni europee. Roberto Baggio e Gabriel Batistuta sono due delle leggende che hanno giocato per la Fiorentina."),
        new Team("Frosinone", "https://www.frosinonecalcio.com/", R.drawable.frosinone, "Frosinone, Lazio", "#3b0099", "Il Frosinone ha avuto una storia più recente in Serie A, raggiungendo la massima divisione per la prima volta nella stagione 2015-2016. Nonostante la retrocessione in Serie B, il club ha continuato a lottare per il ritorno nella massima serie."),
        new Team("Genoa", "https://genoacfc.it/", R.drawable.genoa, "Genova, Liguria", "#d6d304", "Il Genoa è il club più antico del calcio italiano, fondato nel 1893. Ha una storia ricca e ha vinto nove titoli di Serie A, ma negli ultimi decenni ha affrontato periodi di alti e bassi."),
        new Team("Hellas Verona", "https://www.hellasverona.it/", R.drawable.hellas, "Verona, Veneto", "#003cff", "L'Hellas Verona ha avuto successi notevoli, inclusa la vittoria dello scudetto nella stagione 1984-1985. Nonostante alti e bassi, il club ha mantenuto una presenza stabile nella Serie A."),
        new Team("Inter", "https://www.inter.it/it", R.drawable.inter, "Milano, Lombardia", "#fcfcfc", "L'Inter, fondata nel 1908, è il rivale cittadino del Milan. Ha vissuto periodi di successo, inclusi gli anni recenti con l'allenatore José Mourinho, che ha portato la squadra alla vittoria della UEFA Champions League nel 2010. Grandi nomi come Javier Zanetti e Ronaldo hanno indossato la maglia nerazzurra."),
        new Team("Juventus", "https://www.juventus.com/", R.drawable.juventus, "Torino, Piemonte", "#fcfcfc", "La Juventus, fondata nel 1897, è uno dei club più titolati d'Italia. Conosciuta come la \"Vecchia Signora\", ha dominato il calcio italiano per gran parte della sua storia, vincendo numerosi titoli di Serie A e Coppa Italia. La squadra ha avuto giocatori leggendari come Alessandro Del Piero, Michel Platini e Roberto Baggio."),
        new Team("Lazio", "https://www.sslazio.it/it/", R.drawable.lazio, "Roma, Lazio", "#85f7ff", "Fondata nel 1900, la Lazio ha vissuto alti e bassi nella sua storia. Ha vinto diversi titoli di Coppa Italia e una Coppa delle Coppe UEFA. La rivalità con la Roma è uno degli elementi più accesi del calcio italiano."),
        new Team("Lecce", "https://www.uslecce.it/", R.drawable.lecce, "Lecce, Puglia", "#fffc59", "Il Lecce, fondato nel 1908, ha una storia che comprende promozioni e retrocessioni tra Serie A e Serie B. La squadra ha avuto stagioni di successo, conquistando la promozione in Serie A in diverse occasioni e attirando appassionati sostenitori."),
        new Team("Milan", "https://www.acmilan.com/", R.drawable.milan, "Milano, Lombardia", "#e30202", "Il Milan è un altro club di grande successo, con una storia che comprende numerosi titoli nazionali e internazionali. Fondato nel 1899, il Milan ha avuto periodi di grande gloria, specialmente negli anni '80 e '90, con giocatori come Paolo Maldini, Franco Baresi e Marco van Basten."),
        new Team("Monza", "https://www.acmonza.com/", R.drawable.monza, "Monza, Lombardia", "#e30202", "Il Monza è un club con una storia interessante, fondata nel 1912. Dopo aver trascorso gran parte della sua storia nelle divisioni minori, ha ottenuto la promozione in Serie B e successivamente in Serie A, mostrando ambizioni di crescita nel panorama calcistico italiano."),
        new Team("Napoli", "https://sscnapoli.it/", R.drawable.napoli, "Napoli, Campania", "#00d5ff", "l Napoli ha conosciuto il successo soprattutto negli anni '80, quando guidato da Diego Maradona ha conquistato due titoli di Serie A e una Coppa UEFA. Negli anni recenti, il Napoli è tornato ad essere una forza competitiva, sfiorando il titolo nazionale."),
        new Team("Roma", "https://www.asroma.com/it", R.drawable.roma, "Roma, Lazio", "#fa7e02", "La Roma è stata fondata nel 1927 e ha una base di tifosi appassionati. Ha vinto diversi titoli di Serie A e ha raggiunto traguardi notevoli nelle competizioni europee. Francesco Totti è uno dei giocatori più iconici della storia del club."),
        new Team("Salernitana", "https://salernitana.it/", R.drawable.salernitana, "Napoli, Campania", "#b34f4f", "La Salernitana, fondata nel 1919, ha una storia contrassegnata da alti e bassi, con presenze sia in Serie A che in Serie B. La squadra ha affrontato diverse sfide ma ha continuato a essere una presenza significativa nel calcio italiano."),
        new Team("Sassuolo", "https://www.sassuolocalcio.it/", R.drawable.sassuolo, "Bologna, Emilia Romagna", "#218505", "Il Sassuolo è una presenza più recente in Serie A, avendo raggiunto la massima divisione nel 2013. Nonostante la sua giovane età nella massima serie, il club ha mostrato buone prestazioni e si è affermato come una squadra competitiva."),
        new Team("Torino", "https://torinofc.it/", R.drawable.torino, "Torino, Piemonte", "#b34f4f", "Il Torino, fondato nel 1906, è uno dei club più antichi d'Italia. Ha vinto numerosi titoli di Serie A nel corso della sua storia e può vantare una delle tifoserie più appassionate del paese."),
        new Team("Udinese", "https://www.udinese.it/", R.drawable.udinese, "Udine, Friuli Venezia Giulia", "#353635", "L'Udinese ha una storia di consolidamento nella Serie A, con periodi di successo relative al suo impegno nella scoperta e sviluppo di giovani talenti. Fondata nel 1896, la squadra ha mantenuto una presenza costante nella massima serie."),
        //SERIE B
        new Team("Reggiana", "https://reggianacalcio.it/", R.drawable._reggiana, "Reggio Emilia, Emilia Romagna", "#b34f4f", "La Reggiana, fondata nel 1919, ha una storia legata alle divisioni calcistiche italiane. Dopo vari successi e alti nella sua storia, il club è attualmente impegnato in Serie B, cercando di costruire una squadra competitiva e di ritornare ai livelli più alti."),
        new Team("Ascoli", "https://www.ascolicalcio1898.it/", R.drawable._ascoli, "Ascoli, Marche", "#de5540", "L'Ascoli Calcio, fondato nel 1898, ha una storia lunga e variegata. Dopo diversi passaggi tra le serie minori e la Serie B, l'Ascoli è impegnato a raggiungere traguardi più elevati nel panorama calcistico italiano."),
        new Team("Bari", "https://m.sscalciobari.it/it/1/", R.drawable._bari, "Bari, Puglia", "#ff0000", "Il Bari, fondato nel 1908, è un club con una storia appassionante. Dopo essersi affermato in Serie A, il club è attualmente in Serie B e aspira a ritornare ai massimi livelli del calcio italiano."),
        new Team("Brescia", "https://bresciacalcio.it/", R.drawable._brescia, "Brescia, Lombardia", "#00aeff", "Il Brescia Calcio ha una storia altalenante, con periodi di successo in Serie A. La squadra, fondata nel 1911, è attualmente in Serie B e cerca di ritornare nella massima divisione."),
        new Team("Cittadella", "https://www.ascittadella.it/", R.drawable._cittadella, "Padova, Veneto", "#b34f4f", "La squadra di Cittadella ha consolidato la sua presenza in Serie B, dimostrando costanza nelle prestazioni. Fondata nel 1973, la società ha raggiunto una posizione di rilievo nella seconda divisione del calcio italiano."),
        new Team("Como", "https://comofootball.com/", R.drawable._como, "Como, Lombardia", "#f0f1f2", "Il Como Calcio, fondato nel 1907, ha una storia che include presenze in Serie A. Attualmente in Serie B, il club cerca di competere ad alti livelli e di contribuire alla storia del calcio italiano."),
        new Team("Cosenza", "https://www.ilcosenza.it/", R.drawable._cosenza, "Cosenza, Calabria", "#8a1b17", "Il Cosenza Calcio, fondato nel 1912, ha attraversato molte fasi nelle divisioni calcistiche italiane. Con radici profonde, il club calabrese si impegna a competere nella Serie B e a costruire una squadra competitiva."),
        new Team("Cremonese", "https://uscremonese.it/", R.drawable._cremonese, "Cremona, Lombardia", "#9e923a", "La Cremonese, fondata nel 1903, è una delle squadre più antiche d'Italia. Con una storia che comprende momenti di successo in Serie A, la squadra ora è impegnata a competere in Serie B e a costruire il suo futuro."),
        new Team("Sudtirol", "https://www.fc-suedtirol.com/it/index/1-0.html", R.drawable._sudtirol, "Sudtirol, Trentino Alto Adige", "#e00700", "La società Südtirol Calcio, fondata nel 1995, rappresenta la regione dell'Alto Adige. Competendo inizialmente nei campionati dilettantistici, il Südtirol ha gradualmente progredito attraverso le divisioni calcistiche italiane, raggiungendo infine la Serie B. La squadra cerca di consolidare la sua posizione nella seconda divisione e di contribuire alla rappresentanza calcistica dell'Alto Adige a livello nazionale."),
        new Team("FeralpiSalò", "https://feralpisalo.it/", R.drawable._feralpisalo, "Brescia, Lombardia", "#11851b", "Il Feralpisalò è un club che ha guadagnato visibilità negli ultimi anni. Con sede a Salò, in Lombardia, il club compete attivamente in Serie B cercando di consolidare la sua posizione nella seconda divisione."),
        new Team("Lecco", "http://www.calciolecco1912.com/", R.drawable._lecco, "Lecco, Lombardia", "#026cd6", "Il Calcio Lecco 1912, fondato nel 1912, ha una storia caratterizzata da alti e bassi. Con attuali partecipazioni in Serie C e Serie D, il club punta a ritornare in Serie B e a giocare un ruolo significativo nel calcio italiano."),
        new Team("Modena", "https://modenacalcio.com/", R.drawable._modena, "Modena, Lombardia", "#ede213", "Il Modena FC, fondato nel 1912, ha una storia nella quale ha toccato le vette della Serie A. Attualmente in Serie B, il club cerca di costruire una squadra competitiva e di tornare a competere nelle serie superiori."),
        new Team("Parma", "https://www.parmacalcio1913.com/", R.drawable._parma, "Parma, Emilia Romagna", "#fff319", "Il Parma Calcio, dopo aver vissuto momenti di gloria negli anni '90, è tornato in Serie B. Fondata nel 1913, la squadra cerca di risalire le classifiche e di tornare ai fasti passati."),
        new Team("Palermo", "https://www.palermofc.com/it/", R.drawable._palermo, "Palermo, Sicilia", "#fafafa", "Il Palermo, fondato nel 1900, ha una storia che include partecipazioni sia in Serie A che in Serie B. Con una base di tifosi appassionati, il club siciliano aspira a tornare in Serie A e a competere ai massimi livelli."),
        new Team("Pisa", "https://pisasportingclub.com/", R.drawable._pisa, "Pisa, Toscana", "#1202a3", "Il Pisa Calcio ha una storia che risale al 1909. Dopo varie avventure tra le divisioni calcistiche italiane, il club è tornato in Serie B, cercando di affermarsi e aspirando a raggiungere risultati positivi."),
        new Team("Sampdoria", "https://www.sampdoria.it/", R.drawable._sampdoria, "Genova, Liguria", "#ededed", "Fondata nel 1946, la Sampdoria ha vinto uno scudetto e una Coppa delle Coppe UEFA. Ha avuto un periodo di successo negli anni '90, con giocatori come Roberto Mancini e Gianluca Vialli."),
        new Team("Spezia", "https://www.speziacalcio.com/", R.drawable._spezia, "La Spezia, Liguria", "#f0f0f0", "Dopo aver ottenuto la promozione in Serie A, lo Spezia Calcio è ora nuovamente in Serie B. Fondata nel 1906, la squadra cerca di consolidare la sua presenza nella seconda divisione e di prepararsi per future sfide."),
        new Team("Ternana", "https://ternanacalcio.com/", R.drawable._ternana, "Terni, Umbria", "#2c661e", "La Ternana Calcio, fondata nel 1925, ha avuto un ruolo rilevante nelle divisioni minori italiane. Attualmente in Serie B, il club cerca di costruire una squadra competitiva e di aspirare a traguardi più elevati."),
        new Team("Catanzaro", "https://www.uscatanzaro1929.com/", R.drawable._catanzaro, "Catanzaro, Calabria", "#ced11d", "L'US Catanzaro, fondato nel 1929, ha attraversato varie fasi nelle divisioni calcistiche italiane. Attualmente in Serie B, il club calabrese cerca di affermarsi e di competere per la promozione in Serie A."),
        new Team("Venezia", "https://www.veneziafc.it/", R.drawable._venezia, "Venezia, Veneto", "#10521c", "Il Venezia FC, fondato nel 1907, ha una storia intrigante nel calcio italiano. Dopo aver vissuto periodi in Serie A, la squadra è tornata in Serie B con l'obiettivo di risalire le gerarchie del calcio italiano."),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Arrays.sort(teams, Comparator.comparing(team -> team.name)); //Sorting by team name

        RecyclerView recyclerView = findViewById(R.id.recycler_view_projects);
        TeamAdapter projectAdapter = new TeamAdapter(teams);
        recyclerView.setAdapter(projectAdapter);

        projectAdapter.OnItemClickListener((view, position) -> {


            DialogInterface.OnClickListener listener = (dialog, which) -> {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Log.d("Listener", "Premuto conferma");
                        Intent intento = new Intent(MainActivity.this, TeamDetail.class);
                        intento.putExtra("link", teams[position].link);
                        intento.putExtra("logo", teams[position].image);
                        intento.putExtra("name", teams[position].name);
                        intento.putExtra("city", teams[position].city);
                        intento.putExtra("color", teams[position].color);
                        intento.putExtra("desc", teams[position].desc);
                        startActivity(intento);
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Log.d("Listener", "Premuto annulla");
                        break;
                }

            };

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Ciao!")
                    .setMessage("Hai selezionato la seguente squadra: "+teams[position].name + ". Vuoi continuare a esplorare dettagli e opzioni relative a questa squadra?")
                    .setPositiveButton("Sì, confermo.", listener)
                    .setNegativeButton("No, annulla", listener)
                    .show();
        });

    }

}