package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.example.myapplication2.ui.theme.MyApplication2Theme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.text.AnnotatedString
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.platform.LocalContext

data class Section(val title: String, val page: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication2Theme {
                AppNavigation() // Appelle le système de navigation
            }
        }
    }
}

// ⚡ Gestion de la navigation entre les pages
@Composable
fun AppNavigation() {
    val navController = rememberNavController() // Création du contrôleur de navigation

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("foreword") { ForewordScreen(navController) }
        composable("editorial") { EditorialScreen(navController) }
        composable("presentation") { PresentationScreen(navController) }
        composable("acknowledgments") { AcknowledgmentsScreen(navController) }
        composable("global_security_economy") { GlobalSecurityEconomyScreen(navController) }
        composable("usage") { UsageScreen(navController) }

        composable("security_economy") { SecurityEconomyScreen(navController) }
        composable("in_company") { InCompanyScreen(navController) }
        composable("protect_assets") { ProtectAssetsScreen(navController) }
        composable("business_conduct") { BusinessConductScreen(navController) }
        composable("digital") { DigitalScreen(navController) }
        composable("communicate") { CommunicateScreen(navController) }
        composable("outside_company") { OutsideCompanyScreen(navController) }
        composable("annexes") { AnnexesScreen(navController) }
        composable("contacts") { ContactsScreen(navController) } // Ajout de la page Contacts
        // Ajoutez d'autres pages ici si nécessaire
    }
}

// 🏠 Page principale avec le sommaire
@Composable
fun HomeScreen(navController: NavController) {
    val sections = listOf(
        Section("Avant-Propos", "foreword"),
        Section("Éditorial", "editorial"),
        Section("Présentation", "presentation"),
        Section("Remerciements", "acknowledgments"),
        Section("Sécurité Économique Globale", "global_security_economy"),
        Section("Mode d'Emploi", "usage"),
        Section("A – PENSER LA SÉCURITÉ ÉCONOMIQUE", "security_economy"),
        Section("B – DANS L’ENTREPRISE", "in_company"),
        Section("C – PROTÉGER SON PATRIMOINE", "protect_assets"),
        Section("D – LA CONDUITE DES AFFAIRES", "business_conduct"),
        Section("E – LE NUMÉRIQUE", "digital"),
        Section("F – COMMUNIQUER", "communicate"),
        Section("G – À L’EXTÉRIEUR DE L’ENTREPRISE", "outside_company"),
        Section("Annexes", "annexes"),
        Section("CONTACTS UTILES", "contacts") // Ajout de la section Contacts Utiles
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sommaire", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(sections) { section ->
                Button(
                    onClick = { navController.navigate(section.page) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White)
                ) {
                    Text(section.title)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ForewordScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Permet le défilement vertical
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espace entre les éléments
    ) {
        Text(text = "Avant-Propos", style = MaterialTheme.typography.headlineMedium)

        Text(
            text = "J'ai le plaisir de vous présenter « La sécurité économique au quotidien, en 28 fiches pratiques », coordonné par le service de l’information stratégique et de la sécurité économiques (Sisse) du ministère de l’Économie, des Finances et de la Relance.\n\n" +
                    "Ces fiches sont conçues pour aider les dirigeants d’entreprises et les responsables d’administrations à adopter les bons réflexes face aux nouvelles menaces. Depuis 2014, les risques pour la sécurité économique se sont intensifiés, notamment avec l'essor des technologies numériques, qui apportent à la fois des opportunités et des vulnérabilités, en particulier concernant la protection des données.\n\n" +
                    "Il est essentiel que la protection des informations soit une priorité partagée par tous les collaborateurs. De plus, l'utilisation croissante du droit comme instrument de puissance économique, notamment à travers l’extraterritorialité des législations étrangères, souligne l'importance de cette sensibilisation.\n\n" +
                    "Cette nouvelle édition inclut des fiches sur le contrôle des investissements étrangers en France et l'utilisation de la loi de blocage. Je vous encourage à utiliser ces fiches comme un outil quotidien pour renforcer la sécurité économique, qui est l'affaire de chacun.",
            style = MaterialTheme.typography.bodyLarge
        )

        // Ajout de la signature avant le bouton "Retour"
        Box(
            modifier = Modifier.fillMaxWidth(), // Prendre toute la largeur
            contentAlignment = Alignment.BottomEnd // Aligner le contenu en bas à droite
        ) {
            Text(
                text = "Bruno Le Maire,\nMinistre de l’Économie, des Finances et de la Relance",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.End // Alignement du texte à droite
            )
        }

        // Ajout d'un item pour le bouton "Retour"
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth() // Optionnel : pour que le bouton prenne toute la largeur
                .padding(vertical = 16.dp) // Ajout d'un padding vertical pour espacer le bouton
        ) {
            Text("Retour")
        }
    }
}





// 📜 Page Éditorial
@Composable
fun EditorialScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Éditorial", style = MaterialTheme.typography.headlineMedium)

        Text(
            text = "La sécurité des entreprises et la protection de leurs informations stratégiques sont essentielles pour la politique économique du Gouvernement. En tant que commissaire à l’information stratégique, je vous présente cet outil pratique pour vous aider à protéger votre entreprise et son patrimoine informationnel.\n\n" +
                    "Ce guide, élaboré avec le soutien de diverses administrations, couvre des sujets clés de la sécurité économique, incluant des fiches sur le contrôle des investissements étrangers et l'utilisation de la loi de blocage. Les 28 fiches offrent des cas concrets et des outils pour améliorer l'organisation, le comportement des collaborateurs et les mesures techniques.\n\n" +
                    "La sécurité économique est une responsabilité collective. J'espère que ces fiches deviendront une référence utile pour vous au quotidien.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = "Thomas Courbe,\nCommissaire à l’information stratégique\net à la sécurité économiques",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.End
            )
        }
    }
}

// 📖 Page Présentation du SISSE
@Composable
fun PresentationScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Permet le défilement vertical
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espace entre les éléments
    ) {
        Text(text = "Présentation du SISSE", style = MaterialTheme.typography.headlineMedium)

        Text(
            text = "Le Service de l’information stratégique et de la sécurité économiques (Sisse) coordonne la politique de sécurité économique de l’État. Il a établi une liste nationale d’entreprises stratégiques et de technologies critiques à protéger, et supervise les actions des ministères concernés.\n\n" +
                    "Lorsqu'une menace économique étrangère est identifiée, le Sisse organise la coopération entre les acteurs pour prendre des mesures efficaces afin de préserver la souveraineté économique. Il s'appuie sur un réseau de 21 délégués régionaux qui détectent les alertes sur les entreprises stratégiques.\n\n" +
                    "Le Sisse renforce le contrôle des investissements étrangers (IEF) pour mieux gérer les rachats dans des secteurs stratégiques, avec une liste d'activités élargie depuis 2019. Il coordonne également le suivi des engagements des investisseurs étrangers et veille à l'application de la loi sur la communication de documents d’ordre économique à des entités étrangères.\n\n" +
                    "Enfin, le Sisse sensibilise les entreprises, notamment les PME et start-up, sur les bonnes pratiques en matière de sécurité économique, avec un guide pédagogique disponible sur son site.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}


// 📜 Page Remerciements
@Composable
fun AcknowledgmentsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Remerciements", style = MaterialTheme.typography.headlineMedium)

        // Contenu spécifique à cette page
        Text(
            text = "Le Sisse remercie tous les acteurs, publics et privés, qui ont contribué à la rédaction de ces fiches de sécurité économique depuis 2014.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}


// 📊 Page Sécurité Économique Globale
@Composable
fun GlobalSecurityEconomyScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Permet le défilement vertical
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espace entre les éléments
    ) {
        Text(text = "Sécurité Économique Globale", style = MaterialTheme.typography.headlineMedium)

        Text(
            text = "La sécurité économique globale concerne la protection des atouts économiques, technologiques et scientifiques d'un pays face à une compétition accrue et à l'émergence de nouveaux acteurs. Les règles de la compétition économique évoluent, et les stratégies politiques et économiques visent à conquérir des marchés en utilisant des leviers jusqu'alors peu considérés comme stratégiques.\n\n" +
                    "Dans ce contexte, le premier acteur à adopter un positionnement stratégique sur les marchés clés bénéficiera d'un avantage compétitif. Il est donc crucial de protéger les intérêts français pour éviter qu'ils ne soient captés par des acteurs étrangers.\n\n" +
                    "La sécurité économique doit être perçue comme un outil de différenciation positive et un levier de compétitivité, plutôt que comme une contrainte. Elle implique l'analyse et la réduction des risques extra-financiers, tels que la non-conformité, les risques de réputation, les fuites de données stratégiques, et les menaces sur la sécurité des personnes et des biens.\n\n" +
                    "Tous les membres d'une organisation, du dirigeant à l'employé, doivent être impliqués dans la sécurité économique, car chacun contribue à la protection de l'entreprise, qu'il s'agisse d'un grand groupe, d'une start-up, d'une PME, d'une ETI ou d'un organisme de recherche.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}

@Composable
fun UsageScreen(navController: NavController) {
    // État de défilement
    val scrollState = rememberScrollState()
    val context = LocalContext.current // Récupérer le contexte

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Mode d'Emploi", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = """
                Comment aborder ce recueil de fiches ?

                Ces fiches s'adressent à un large public, incluant toutes les entreprises, organismes de recherche et administrations, regroupés sous le terme « d’entreprise ». Chaque thématique est abordée sous différents angles, avec des recommandations classées en trois rubriques :

                - Organisationnel : pour les managers.
                - Technique : pour les responsables de la sécurité des systèmes d’information et parfois pour tous les employés.
                - Comportemental : pour tous, indépendamment du niveau hiérarchique.

                Les fiches sont organisées en sept familles :

                A – Penser la sécurité économique  
                B – Dans l’entreprise  
                C – Protéger son patrimoine  
                D – La conduite des affaires  
                E – Le numérique  
                F – Communiquer  
                G – À l’extérieur de l’entreprise  

                Chaque fiche propose des rubriques « Mots-clés » et « Pour aller plus loin » pour approfondir les notions abordées.

                Contacts en région : Pour signaler une alerte de sécurité économique, contactez les délégués à l’information stratégique et à la sécurité économiques (Disse) de votre région.
            """.trimIndent(),
            style = MaterialTheme.typography.bodyLarge
        )

        // Liste des contacts avec des liens
        val contacts = listOf(
            "Auvergne-Rhône-Alpes" to "ara.disse@dreets.gouv.fr",
            "Bourgogne-Franche-Comté" to "bfc.disse@dreets.gouv.fr",
            "Bretagne" to "dreets-bret.disse@dreets.gouv.fr",
            "Centre Val de Loire" to "dreets-cvl.disse@dreets.gouv.fr",
            "Corse" to "corse.corres-sisse@dreets.gouv.fr",
            "Grand Est" to "ge.disse@dreets.gouv.fr",
            "Hauts-de-France" to "hdf.disse@dreets.gouv.fr",
            "Île-de-France" to "drieets-idf.disse@dreets.gouv.fr",
            "Normandie" to "dreets-norm.disse@dreets.gouv.fr",
            "Nouvelle-Aquitaine" to "dreets-na.disse@dreets.gouv.fr",
            "Occitanie" to "oc.disse@dreets.gouv.fr",
            "Pays de la Loire" to "pdl.disse@dreets.gouv.fr",
            "Provence-Alpes-Côte d’Azur" to "paca.disse@dreets.gouv.fr",
            "Antilles Guyane" to "971.disse@deets.gouv.fr",
            "Océan indien" to "974.disse@dreets.gouv.fr"
        )

        // Affichage des contacts
        contacts.forEach { (region, email) ->
            ClickableText(
                text = AnnotatedString("$region : $email"),
                onClick = { offset ->
                    val emailStart = region.length + 3 // 3 pour ": "
                    if (offset in emailStart until (emailStart + email.length)) {
                        // Ouvrir l'application de messagerie
                        val intent = Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:$email") // seulement les applications de messagerie
                            putExtra(Intent.EXTRA_SUBJECT, "Alerte de sécurité économique") // Sujet de l'email
                        }
                        // Vérifiez qu'il existe une application qui peut gérer cet Intent
                        if (intent.resolveActivity(context.packageManager) != null) {
                            context.startActivity(intent) // Démarrer l'intent
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(4.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Note de bas de page
        Text(
            text = "* Une alerte de sécurité économique peut inclure des menaces telles que le vol de données, des tentatives d'escroquerie, ou des approches non souhaitées d'investisseurs étrangers.",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Bouton de retour
        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}




// 👮 Page Sécurité Économique
@Composable
fun SecurityEconomyScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sécurité Économique", style = MaterialTheme.typography.headlineMedium)

        // Résumé des points clés
        Text(
            text = """
                A – PENSER LA SÉCURITÉ ÉCONOMIQUE
                
                A1. Politique de sécurité :
                - Établir une politique de sécurité économique intégrée, impliquant tous les employés.
                - Identifier les risques, menaces et vulnérabilités via un diagnostic général.
                - Affecter des ressources humaines, financières et matérielles pour une mise en œuvre efficace.
                - Mettre en place des procédures et des formations adaptées à chaque service.
                - Suivre les objectifs de sécurité par des audits réguliers et des tableaux de bord.
                - Créer un dialogue continu sur les problématiques de sécurité au sein de l'entreprise.

                A2. Processus de veille :
                - Mettre en place une veille informationnelle pour anticiper les évolutions de l'environnement.
                - Identifier les besoins d'information et prioriser les thèmes de recherche.
                - Utiliser des outils de veille adaptés et diversifier les sources d'information.
                - Encourager une culture de vigilance où chaque employé contribue à la veille.

                A3. Protection de l'information stratégique :
                - Identifier les informations critiques à protéger, en fonction de leur sensibilité.
                - Évaluer les risques liés à la divulgation ou à la perte d'informations stratégiques.
                - Appliquer des mesures de protection adaptées, comme des droits d'accès régulés.
                - Réévaluer régulièrement les informations stratégiques pour s'assurer de leur pertinence.

                Attention au Cloud Act :
                - Prendre en compte les risques liés à la protection des données des entreprises françaises utilisant des fournisseurs américains, en raison des implications du Cloud Act.
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium
        )

        // Bouton de retour
        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}


// 🏢 Page Dans l'Entreprise
@Composable
fun InCompanyScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Dans l'Entreprise", style = MaterialTheme.typography.headlineMedium)

        // Résumé des points clés
        Text(
            text = """
                B – DANS L’ENTREPRISE
                
                B1. Protéger ses locaux :
                - Désigner un responsable sûreté pour rédiger et contrôler les procédures.
                - Identifier les flux d'entrées/sorties et hiérarchiser les zones à protéger.
                - Réglementer l'accès aux zones et établir un journal des incidents.
                - Sensibiliser le personnel aux règles de sécurité et évaluer le système de contrôle d'accès.
                - Utiliser des moyens de protection mécaniques (clôtures, éclairage, contrôle d'accès).
                - Installer des systèmes de détection d'intrusion et de vidéosurveillance.

                B2. Accueillir et encadrer du personnel temporaire :
                - Connaître le parcours du personnel temporaire avant son arrivée.
                - Désigner un responsable pour l'encadrement et tenir un répertoire des non-permanents.
                - Sensibiliser le personnel temporaire aux mesures de sécurité et imposer un badge.
                - Limiter l'accès aux systèmes d'information et clôturer les comptes après leur départ.

                B3. Encadrer des visiteurs :
                - Impliquer le personnel lors de visites sensibles et vérifier l'identité des visiteurs.
                - Élaborer une procédure d'accueil et définir un parcours de visite sécurisé.
                - Accompagner les visiteurs et enregistrer leurs horaires d'entrée/sortie.
                - Encadrer l'utilisation d'outils numériques et signaler tout problème.

                Mots clés : Circuit de notoriété - circuit préétabli pour visiter l'entreprise tout en évitant les zones sensibles.
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium
        )

        // Bouton de retour
        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}


// 🏦 Page Protéger Son Patrimoine
@Composable
fun ProtectAssetsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Protéger Son Patrimoine", style = MaterialTheme.typography.headlineMedium)

        // Section sur la protection du savoir et des idées
        Text(text = "1. Protéger son savoir et ses idées", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Identifier les titres de propriété intellectuelle adaptés.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Vérifier la disponibilité des droits auprès de l'Inpi.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Enregistrer ses droits auprès des offices compétents.", style = MaterialTheme.typography.bodyMedium)

        // Section sur la gestion des compétences clés
        Text(text = "2. Éviter ou gérer la perte d’une compétence clé", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Cartographier les compétences clés.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Surveiller les offres d’emploi concurrentes.", style = MaterialTheme.typography.bodyMedium)

        // Section sur la gestion des archives
        Text(text = "3. Gérer ses archives et ses rejets", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Mettre en place un plan de classement et d’archivage.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Sensibiliser les employés à la destruction sécurisée des données.", style = MaterialTheme.typography.bodyMedium)

        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}


@Composable
fun BusinessConductScreen(navController: NavController) {
    // Créer un état de défilement
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState), // Activer le défilement vertical
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "La Conduite des Affaires", style = MaterialTheme.typography.headlineMedium)

        // Section sur la sécurisation des financements extérieurs
        Text(text = "1. Sécuriser son recours aux financements extérieurs", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Définir le besoin de financement en accord avec la stratégie.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Vérifier la réputation des investisseurs et leur connaissance du secteur.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• S'assurer de la fiabilité des plateformes de financement participatif.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Éviter les négociations avec des acteurs aux intentions hostiles.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Maîtriser la communication et ne divulguer aucune information stratégique.", style = MaterialTheme.typography.bodyMedium)

        // Section sur le contrôle des investissements étrangers
        Text(text = "2. Utiliser la procédure de contrôle des investissements étrangers", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Vérifier si l'investissement nécessite une autorisation.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Demander un rescrit si nécessaire pour évaluer l'éligibilité.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Déposer un dossier auprès de la direction générale du Trésor.", style = MaterialTheme.typography.bodyMedium)

        // Section sur les escroqueries au président
        Text(text = "3. Se prémunir des escroqueries au président (Fovi)", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Sensibiliser le personnel aux escroqueries.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Mettre en place des procédures de vérification pour les paiements.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Respecter les procédures malgré les pressions.", style = MaterialTheme.typography.bodyMedium)

        // Section sur la conformité
        Text(text = "4. Se prémunir des risques de conformité (compliance)", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Nommer un responsable conformité indépendant.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Rédiger une charte éthique et sensibiliser le personnel.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Mettre en place un dispositif d'alerte pour signaler les situations à risque.", style = MaterialTheme.typography.bodyMedium)

        // Section sur le contrôle de l'organisation
        Text(text = "5. Contrôler son organisation", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Vérifier l’honorabilité des partenaires et des tiers externes.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Contrôler la conformité aux normes juridiques et éthiques.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Dresser une cartographie des risques adaptée à l'entreprise.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Conduire des audits pour identifier les failles organisationnelles.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Limiter l'accès aux données lors d'audits externes.", style = MaterialTheme.typography.bodyMedium)

        // Section sur la réaction face à une demande d'autorité étrangère
        Text(text = "6. Réagir face à une demande d'autorité étrangère", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Identifier les informations stratégiques à protéger.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Protéger juridiquement l'entreprise avec des clauses adaptées.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Contacter le Sisse pour accompagner la demande.", style = MaterialTheme.typography.bodyMedium)

        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}





// 💻 Page Le Numérique
@Composable
fun DigitalScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Le Numérique", style = MaterialTheme.typography.headlineMedium)

        // Section sur la protection contre les rançongiciels
        Text(text = "1. Se protéger contre les rançongiciels", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Effectuer des sauvegardes régulières des données, de préférence sur un support déconnecté.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Ne pas payer les rançons et signaler l'incident aux autorités.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Mettre à jour automatiquement tous les logiciels pour limiter les vulnérabilités.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Utiliser un compte 'utilisateur' pour réduire les risques de propagation.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Restreindre l'activation des macros dans les logiciels bureautiques.", style = MaterialTheme.typography.bodyMedium)

        // Section sur la protection du poste de travail
        Text(text = "2. Protéger son poste de travail", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Appliquer une politique de mots de passe robustes (12 caractères min).", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Mettre à jour régulièrement le système et les logiciels.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Utiliser un pare-feu et un antivirus.", style = MaterialTheme.typography.bodyMedium)

        // Section sur la protection et gestion de l'accès au système d'information
        Text(text = "3. Protéger et gérer l'accès au système d'information", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Tenir à jour la liste des équipements connectés au réseau.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Attribuer des droits d'accès adaptés aux besoins.", style = MaterialTheme.typography.bodyMedium)

        // Section sur l'utilisation sécurisée des supports amovibles
        Text(text = "4. Utiliser des supports amovibles de façon sécurisée", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Interdire les supports amovibles personnels sur le réseau de l'entreprise.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Chiffrer les supports amovibles pour protéger les données.", style = MaterialTheme.typography.bodyMedium)

        // Section sur la sécurisation du télétravail
        Text(text = "5. Sécuriser le télétravail", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Éviter l'utilisation d'appareils personnels sans contrôle.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Chiffrer les données sensibles et effectuer des sauvegardes régulières.", style = MaterialTheme.typography.bodyMedium)

        // Section sur la maîtrise de l'externalisation informatique
        Text(text = "6. Maîtriser l'externalisation informatique", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Déterminer les besoins en externalisation et intégrer des objectifs de sécurité.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Rédiger des contrats personnalisés avec des spécialistes.", style = MaterialTheme.typography.bodyMedium)

        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}



// 📢 Page Communiquer
@Composable
fun CommunicateScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Communiquer", style = MaterialTheme.typography.headlineMedium)

        // Section sur la maîtrise de la communication
        Text(text = "1. Maîtriser sa communication", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Centraliser et valider toute communication externe avec la direction.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Préparer minutieusement les interventions publiques et identifier les informations sensibles.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Sensibiliser aux risques des sollicitations urgentes et établir une procédure d'urgence.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Vérifier la légitimité des audits et contrôles.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Surveiller l'e-réputation et réagir rapidement aux informations nuisibles.", style = MaterialTheme.typography.bodyMedium)

        // Section sur l'utilisation sécurisée des réseaux sociaux
        Text(text = "2. Utiliser les réseaux sociaux en toute sécurité", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Établir une charte sur l'usage des réseaux sociaux et sensibiliser le personnel.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Éviter de partager des informations sensibles et utiliser des mots de passe forts.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Vérifier les paramètres de confidentialité et rester vigilant face aux sollicitations.", style = MaterialTheme.typography.bodyMedium)

        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}


// 🌍 Page À l'Extérieur de l'Entreprise
@Composable
fun OutsideCompanyScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "À l'Extérieur de l'Entreprise", style = MaterialTheme.typography.headlineMedium)

        // Section sur les déplacements quotidiens
        Text(text = "1. Se déplacer au quotidien", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Installer un filtre de confidentialité sur les écrans des appareils.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Éviter de transporter des données sensibles lors des déplacements.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Désactiver Wifi/Bluetooth dans les transports en commun.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Rester discret dans les lieux publics et ne pas laisser ses outils sans surveillance.", style = MaterialTheme.typography.bodyMedium)

        // Section sur les déplacements à l'étranger
        Text(text = "2. Se déplacer à l'étranger", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Vérifier la situation politico-sécuritaire du pays de destination.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Préparer les numéros d'urgence et conserver des copies de documents importants.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Ne pas considérer le coffre-fort de l'hôtel comme sûr pour les informations sensibles.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Rester vigilant dans les communications et éviter les connexions non sécurisées.", style = MaterialTheme.typography.bodyMedium)

        // Section sur la participation à un salon professionnel
        Text(text = "3. Participer à un salon professionnel", style = MaterialTheme.typography.bodyLarge)
        Text(text = "• Définir les informations à diffuser et préparer des éléments de langage.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Sécuriser le matériel et limiter les documents sensibles.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "• Éviter les conversations sensibles dans les lieux publics et surveiller ses outils de travail.", style = MaterialTheme.typography.bodyMedium)

        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}


@Composable
fun AnnexesScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Annexes", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Voici les annexes du document.", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Contenu des annexes
        Text(text = "ANNEXE 1 : Rapport d’étonnement\n" +
                "Document signalant des faits ou comportements inhabituels.\n" +
                "Types de faits : internes (comportements atypiques) et externes (comportements observés).\n" +
                "Méthodologie : sensibilisation, identification des destinataires, modèle de rapport, confidentialité.\n\n" +
                "ANNEXE 2 : Loi Sapin II\n" +
                "Renforcement de la lutte contre la corruption avec des obligations pour les grandes entreprises.\n" +
                "Obligations : Code de conduite, procédure d’alerte, cartographie des risques, vérification des partenaires, contrôles comptables, formations, sanctions disciplinaires, contrôle interne.\n\n" +
                "ANNEXE 4 : Cloud Act\n" +
                "Clarifie l’usage des données hébergées hors des États-Unis, permettant aux autorités américaines d'accéder à des données sans procédure d’entraide judiciaire.\n" +
                "Les entreprises doivent privilégier les prestataires européens.")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}


// 📞 Page Contacts Utiles
@Composable
fun ContactsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Ajout du défilement vertical
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Contacts Utiles", style = MaterialTheme.typography.headlineMedium)

        // Contenu des contacts utiles
        Text(text = "1. Ministère des Armées - DRSD\n" +
                "Service de renseignement pour la sécurité du personnel et des installations sensibles.\n" +
                "Site : http://www.defense.gouv.fr/dpsd", style = MaterialTheme.typography.bodyLarge)

        Text(text = "2. Ministère de l'Économie - DGDDI\n" +
                "Facilite et sécurise les flux de marchandises.\n" +
                "Contact : contrefac@douane.finances.gouv.fr", style = MaterialTheme.typography.bodyLarge)

        Text(text = "3. Service du Haut fonctionnaire de défense et de sécurité (SHFDS)\n" +
                "Conseil sur les mesures de défense et de sécurité.\n" +
                "Site : https://www.economie.gouv.fr/hfds", style = MaterialTheme.typography.bodyLarge)

        Text(text = "4. Service de l'information stratégique et de la sécurité économiques (Sisse)\n" +
                "Identifie les secteurs et technologies d'intérêt économique.\n" +
                "Site : www.entreprises.gouv.fr/information-strategique-Sisse", style = MaterialTheme.typography.bodyLarge)

        Text(text = "5. Institut national de la propriété industrielle (Inpi)\n" +
                "Enregistrement de titres de propriété industrielle et soutien à l'innovation.\n" +
                "Site : www.inpi.fr - contact@inpi.fr", style = MaterialTheme.typography.bodyLarge)

        Text(text = "6. Brigade d'enquêtes sur les fraudes aux technologies de l'information (Befti)\n" +
                "Lutte contre la cybercriminalité.\n" +
                "Victimes invitées à déposer plainte auprès des commissariats.", style = MaterialTheme.typography.bodyLarge)

        Text(text = "7. Direction générale de la sécurité intérieure (DGSI)\n" +
                "Référence sur les menaces économiques étrangères.\n" +
                "Contact : securite-economique@interieur.gouv.fr", style = MaterialTheme.typography.bodyLarge)

        Text(text = "8. Agence nationale de la sécurité des systèmes d'information (Anssi)\n" +
                "Sécurité des systèmes d'information de l'État.\n" +
                "Site : www.anssi.gouv.fr", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Retour")
        }
    }
}




// 🔍 Aperçu de l'écran principal dans Android Studio
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyApplication2Theme {
        HomeScreen(navController = rememberNavController())
    }
}


