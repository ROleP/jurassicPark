package com.rolep.sf.filediff;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by rolep on 13/09/16.
 */
public class Solution {

    public static String newCompOne = "Oni Telecom\n" +
                "FSE CONSULTING\n" +
                "CLX Networks\n" +
                "CSG International\n" +
                "MASMOVIL\n" +
                "UPM Technology GmbH\n" +
                "UPM Telecom\n" +
                "CallCaribe\n" +
                "FOREST INTERACTIVE SDN BHD\n" +
                "FOREST INTERACTIVE SDN BHD\n" +
                "Americatel Communications S.L.\n" +
                "DASA TELECOMS\n" +
                "Telefonica\n" +
                "Nobel LTD\n" +
                "Nobel LTD\n" +
                "Neogenia s.r.o.\n" +
                "ONITELECOM\n" +
                "BG Laptop Ltd\n" +
                "Yoigo\n" +
                "TELECOM JET BUSINESS S.L.\n" +
                "TELECOM JET BUSINESS S.L.\n" +
                "TELECOM JET BUSINESS S.L.\n" +
                "GTC\n" +
                "Kamilia Voip srl\n" +
                "SAMA\n" +
                "Aroli Technologies\n" +
                "Callr\n" +
                "WIP TELECOM\n" +
                "RouteTrader Limited\n" +
                "TELKIA\n" +
                "BeirutIT\n" +
                "BeirutIT\n" +
                "Interconnect\n" +
                "AVyS Telecom\n" +
                "WANATEL\n" +
                "Herr\n" +
                "DIGITALK\n" +
                "Crossingnet Srl\n" +
                "Phonegroup\n" +
                "Comunica It Services SA\n" +
                "INFO-Telecom\n" +
                "IP Telecom Bulgaria\n" +
                "FBDTEL\n" +
                "FBDTEL\n" +
                "China Mobile International (UK) Limited\n" +
                "China Mobile International (UK) Limited\n" +
                "D Telecom Srl\n" +
                "MÁSMÓVIL\n" +
                "Novatel d.o.o.\n" +
                "G729 S.L\n" +
                "Portugal Telecom\n" +
                "Vox Carrier\n" +
                "Callcaribe\n" +
                "ORAKOM SRL\n" +
                "Premier Telecom Ltd\n" +
                "PCCW Global Ltd\n" +
                "PCCW Global Ltd\n" +
                "Intermatica S.p.A\n" +
                "VueTel Italia \n" +
                "ADC Telecom\n" +
                "Teknolab Holding\n" +
                "JSC Kaztranscom\n" +
                "Etisalat\n" +
                "Pioneer Trading S.A.L\n" +
                "RE.GI. srl\n" +
                "Neofone\n" +
                "Kalam Communication\n" +
                "Zaheen Telecom\n" +
                "Deutsche Telekom ICSS\n" +
                "INFO-Telecom\n" +
                "INFO-Telecom\n" +
                "Munitel UG\n" +
                "UNIFI \n" +
                "Go4mobility Lda\n" +
                "Neustar\n" +
                "M-STAT\n" +
                "MessageBird\n" +
                "JT Global\n" +
                "Encontacto.pe\n" +
                "Encontacto.pe\n" +
                "INTIS TELECOM\n" +
                "TATA COMMUNICATIONS LTD\n" +
                "MessageBird B.V.\n" +
                "JT Global\n" +
                "Granntech LTD\n" +
                "OpenMarket\n" +
                "NTH Mobile\n" +
                "NTH Mobile\n" +
                "Esteria SMS\n" +
                "tyntec\n" +
                "Sunrise Communications AG\n" +
                "BSG \n" +
                "Intis Telecom\n" +
                "Silverstreet\n" +
                "interactive digital media GmbH\n" +
                "Whatever Mobile\n" +
                "Quintatech\n" +
                "Beepsend\n" +
                "SmsCoin\n" +
                "Clickatell\n" +
                "Deutsche Telekom AG ICSS\n" +
                "moklix - White-label VAS Operations\n" +
                "Ubiquity International SA\n" +
                "QuickMobile\n" +
                "QuickMobile\n" +
                "Silverstreet\n" +
                "Tata Communicaitons\n" +
                "Clickatell\n" +
                "Clickatell\n" +
                "SAP Mobile Services\n" +
                "Telecom Italia Sparkle\n" +
                "CELLUSYS\n";
    static String newCompTwo = "Ana \n" +
            "Florence \n" +
            "Javier \n" +
            "Gustavo \n" +
            "OSCAR \n" +
            "Thomas\n" +
            "Javier \n" +
            "Pablo \n" +
            "Johary \n" +
            "Inez \n" +
            "Joaquín \n" +
            "Manuel \n" +
            "Carlos \n" +
            "Liviu \n" +
            "Valentin \n" +
            "Jan \n" +
            "Maria da Conceição \n" +
            "Ekaterina \n" +
            "DAVID \n" +
            "MONICA \n" +
            "LUIS MARIA \n" +
            "HARLYN RAFAEL \n" +
            "José A. \n" +
            "Julio \n" +
            "Ali \n" +
            "Arnaud \n" +
            "Sam \n" +
            "Yves \n" +
            "Andrew \n" +
            "Jose Carlos \n" +
            "Joseph \n" +
            "Joe \n" +
            "Svetlana \n" +
            "Pedro \n" +
            "Youssef \n" +
            "Christian Pellegrini\n" +
            "NICK \n" +
            "Gennaro \n" +
            "Andrea \n" +
            "Laura \n" +
            "Cedric \n" +
            "Dmytro \n" +
            "ILIR \n" +
            "BORANA \n" +
            "Alan \n" +
            "Lee \n" +
            "Dante \n" +
            "NURIA \n" +
            "Marina \n" +
            "ROMINA \n" +
            "Rita \n" +
            "Monica\n" +
            "Monica \n" +
            "MASSIMILIANO \n" +
            "Pav\n" +
            "Mauro \n" +
            "Fabio \n" +
            "Simon Franco\n" +
            "MARIA FLORENCIA \n" +
            "Antonio \n" +
            "Irina \n" +
            "Gareth \n" +
            "Yuliya \n" +
            "Oksana \n" +
            "FEDERICO \n" +
            "Bledar \n" +
            "Ibrahim \n" +
            "Marius Alexandru \n" +
            "Ian \n" +
            "Marin \n" +
            "Paul \n" +
            "Mahdi \n" +
            "Stefania \n" +
            "Rui \n" +
            "Tim \n" +
            "Ion \n" +
            "Kenneth \n" +
            "Kevin \n" +
            "Geral \n" +
            "José \n" +
            "Larissa \n" +
            "VIVEK \n" +
            "Monne \n" +
            "James \n" +
            "Sayde \n" +
            "Duncan \n" +
            "Vlaho \n" +
            "Nejla \n" +
            "Andrejs \n" +
            "Andreas \n" +
            "Michael \n" +
            "Ruslan \n" +
            "Adele\n" +
            "Michal \n" +
            "Wael \n" +
            "Edina \n" +
            "Vítor \n" +
            "FELIPE \n" +
            "Irina \n" +
            "Caitlin \n" +
            "Christian \n" +
            "Fabio \n" +
            "Daniele \n" +
            "Peterson Rosa \n" +
            "Filipe \n" +
            "Diksha\n" +
            "Paul \n" +
            "Casper \n" +
            "Simon \n" +
            "Ignacio \n" +
            "Carmen \n" +
            "Craig \n";
    static String newCompThree = "Freitas\n" +
            "SEBASTIEN\n" +
            "Irisarri\n" +
            "Camano\n" +
            "MELERO\n" +
            "Sorgalla\n" +
            "Mendoza\n" +
            "Sedan\n" +
            "Bin Mustapha\n" +
            "Santosa\n" +
            "González  Gomez\n" +
            "Garcia Manso\n" +
            "Piñango\n" +
            "Radu-Popescu\n" +
            "Floroiu\n" +
            "Simecky\n" +
            "Marinho Teixeira Alves Inácio\n" +
            "Hadjiatanasova\n" +
            "GALAN\n" +
            "CODESAL MAYO\n" +
            "LOPEZ CIFUENTES\n" +
            "CHÉRREZ LUCERO \n" +
            "García\n" +
            "Pereira\n" +
            "Yahya\n" +
            "Tokpa\n" +
            "Herring\n" +
            "MOREAU\n" +
            "Folwell\n" +
            "Alvarez-Gascon\n" +
            "Mardirossian\n" +
            "Farah\n" +
            "Veremeeva\n" +
            "Morfi\n" +
            "FADILI\n" +
            "Pellegrini \n" +
            "COWLEY\n" +
            "Cerulli\n" +
            "Beneforti\n" +
            "Diana\n" +
            "Ferrari\n" +
            "Tokar\n" +
            "BICI\n" +
            "SHEHU\n" +
            "Zhang\n" +
            "Homans-Yau\n" +
            "Lolli\n" +
            "ZURRÓN\n" +
            "Dulčić\n" +
            "KABOORANI\n" +
            "Lopes Taborda Vaz\n" +
            "Lungu\n" +
            "Barreiros-Cables\n" +
            "PECORA\n" +
            "Kang\n" +
            "Fondacaro\n" +
            "Bottan\n" +
            "Pecorelli\n" +
            "MENDOZA\n" +
            "Mellone\n" +
            "Drossler\n" +
            "Evers\n" +
            "Gorbunova\n" +
            "Dasko\n" +
            "PEREZ CASAS\n" +
            "Jani\n" +
            "Rayyan\n" +
            "CRACIUN\n" +
            "Kanpman \n" +
            "Gjonaj\n" +
            "Croitoru\n" +
            "Darwiche\n" +
            "Marra\n" +
            "Cordeiro\n" +
            "Ward\n" +
            "Badekas\n" +
            "Drenthe\n" +
            "Graham\n" +
            "Flemming\n" +
            "Chavez\n" +
            "Youmanova\n" +
            "CHAND \n" +
            "Sombroek\n" +
            "Trenholme \n" +
            "Bahsa\n" +
            "Morton\n" +
            "Kaminski\n" +
            "Bunic\n" +
            "Borisenoks\n" +
            "Heimgartner\n" +
            "Schneider\n" +
            "Naurzalin\n" +
            "Khusnutdinova\n" +
            "Krawczyk\n" +
            "Kadouh\n" +
            "Dervisbegovic\n" +
            "Mesquita\n" +
            "GUTIERREZ\n" +
            "Izverskaya\n" +
            "Frates\n" +
            "Krassowka\n" +
            "Costa\n" +
            "Mensi\n" +
            "Querino\n" +
            "Guelber Melo\n" +
            "Rao\n" +
            "Johnson\n" +
            "de Villiers\n" +
            "Nainkin\n" +
            "Gonzalo\n" +
            "López Garrido\n" +
            "Allen\n";
    static String oldCompOne = "MCC\n" +
            "Mediafon Carrier Services, UAB\n" +
            "Mediatel\n" +
            "Mediatel\n" +
            "Mediatel\n" +
            "MessageBird\n" +
            "MessageBird\n" +
            "MessageBird B.V.\n" +
            "Messente Communications Ltd\n" +
            "Micro Ocean Technologies S/B\n" +
            "MITTO AG\n" +
            "MITTO AG\n" +
            "MITTO AG\n" +
            "MITTO AG\n" +
            "MITTO AG\n" +
            "MMD Smart\n" +
            "MMD SMART LTD\n" +
            "Mobiadvanced Interactive Limited\n" +
            "MOBIK d.o.o.\n" +
            "Mobik d.o.o.\n" +
            "Mobile Ecosystem Forum\n" +
            "Mobily.ws (Typical Network)\n" +
            "MOBIWEB\n" +
            "Mobyt SpA\n" +
            "MoceanSMS\n" +
            "Monty Mobile\n" +
            "Mr Messaging\n" +
            "Mr Messaging Limited\n" +
            "Mr Messaging Limited\n" +
            "NAWC S.A.\n" +
            "Netvoip Chile\n" +
            "Nexmo\n" +
            "Nexmo\n" +
            "Nexmo\n" +
            "Nexmo\n" +
            "Nexmo\n" +
            "NEXT-TEL KFT\n" +
            "NEXT-TEL KFT\n" +
            "NL OMEGA\n" +
            "Nobel LTD\n" +
            "Nobel LTD\n" +
            "Nobel LTD\n" +
            "Nobel LTD\n" +
            "NORD CONNECT\n" +
            "NOS Comunicaçoes\n" +
            "NOS Comunicações\n" +
            "NOS Comunicações\n" +
            "Novatel d.o.o.\n" +
            "NovoTel Limited\n" +
            "NRS GATEWAY\n" +
            "NRSGATEWAY\n" +
            "NTH AG\n" +
            "NTH Mobile\n" +
            "OKRoute\n" +
            "OKRoute\n" +
            "OpenMarket\n" +
            "OpenMarket\n" +
            "OpenMarket\n" +
            "OpenMarket\n" +
            "ORANGE\n" +
            "Orange\n" +
            "Orange\n" +
            "Orange\n" +
            "Orange\n" +
            "Orange\n" +
            "Orange\n" +
            "ORANGE\n" +
            "Orange\n" +
            "Orange\n" +
            "Orange\n" +
            "Orange\n" +
            "ORANGE\n" +
            "Orange\n" +
            "Orange\n" +
            "ORANGE SPAIN\n" +
            "ORBITEL / TIGOUNE\n" +
            "ORBITEL / TIGOUNE\n" +
            "ORBITEL / TIGOUNE\n" +
            "OTEGLOBE\n" +
            "OTEGLOBE\n" +
            "OTEGLOBE\n" +
            "Panacea Mobile\n" +
            "Panamax Infotech Ltd\n" +
            "PCCW Global\n" +
            "PCCW Global\n" +
            "PCCW Global\n" +
            "Peerless Network\n" +
            "Peerless Network\n" +
            "Phonegroup\n" +
            "Phonegroup\n" +
            "PHONETIME  ( A TELLZA COMPANY)\n" +
            "Phonetime - Tellza\n" +
            "PLD International\n" +
            "PLD International\n" +
            "Portugal Telecom\n" +
            "Portugal Telecom\n" +
            "Prab CS\n" +
            "PREMIATEL PTE. Limited\n" +
            "Prolinks S.A.L\n" +
            "Prolinks S.A.L\n" +
            "PTGi - International Carrier Services\n" +
            "PTGi-ICS\n" +
            "R&D Communication S.r.l.\n" +
            "R&D Communication Srl\n" +
            "R&D Communication Srl\n" +
            "REVE Systems\n" +
            "REVE Systems\n" +
            "Rosa GlobalTel\n" +
            "Route Mobile Limited\n" +
            "Route Mobile Limited\n" +
            "Route Mobile Limited\n" +
            "Route Mobile Limited\n" +
            "Route Mobile Limited\n" +
            "Route Mobile Limited\n" +
            "Route Mobile Limited\n" +
            "Route Mobile Limited\n" +
            "Rovex Telecom\n" +
            "Rovex Telecom\n" +
            "RSCom\n" +
            "RSCom\n" +
            "RSCom\n" +
            "RSCom Ltd.\n" +
            "Sales Head\n" +
            "Samitel\n" +
            "Screen-Magic Mobile Media Inc.\n" +
            "Screen-Magic Mobile Media Inc.\n" +
            "SFR\n" +
            "Sheng Li Telecom\n" +
            "Sheng Li Telecom\n" +
            "SIGMA TELECOM\n" +
            "SIGMA TELECOM\n" +
            "SIGMA TELECOM\n" +
            "SIGMA TELECOM\n" +
            "SIGMA TELECOM\n" +
            "SIGMA TELECOM\n" +
            "SIGMA TELECOM\n" +
            "SIGMA TELECOM\n" +
            "SIGMA TELECOM\n" +
            "Sigma Telecom\n" +
            "Silverstreet\n" +
            "Silverstreet BV\n" +
            "SIMBERRY\n" +
            "Simberry\n" +
            "Singularity srl\n" +
            "Singularity Srl\n" +
            "Singularity Srl\n" +
            "Sipstatus Communications SRL\n" +
            "Sipstatus Communications SRL\n" +
            "SMARTBRIDGE TRADING SOLUTIONS PVT LTD\n" +
            "SMARTBRIDGE TRADING SOLUTIONS PVT LTD\n" +
            "SMARTBRIDGE TRADING SOLUTIONS PVT LTD\n" +
            "Solutions Infini Technologies Pvt. Ltd.\n" +
            "Solutions Infini Technologies Pvt. Ltd.\n" +
            "Solutions Infini Technologies Pvt. Ltd.\n" +
            "Solutions Infini Technologies Pvt. Ltd.\n" +
            "Spactron\n" +
            "\n" +
            "SPECTRUM ICA\n" +
            "SPECTRUM ICA\n" +
            "SpoTel\n" +
            "SpoTel\n" +
            "SpoTel\n" +
            "Stanacard LLC\n" +
            "SULTAN TELECOM\n" +
            "SULTAN TELECOM\n" +
            "Sultan Telecom\n" +
            "Sunrise Communications AG\n" +
            "Sunrise Communications AG\n" +
            "SWIFTEL INTERNATIONAL\n" +
            "SWIFTEL INTERNATIONAL\n" +
            "Swissphone Carrier AG\n" +
            "Switch Market\n" +
            "Switch Market\n" +
            "T2R Ltd\n" +
            "TATA Communications\n" +
            "TATA COMMUNICATIONS LTD\n" +
            "TCG TELECOM UAB\n" +
            "TCG TELECOM UAB\n" +
            "TELARIX\n" +
            "Telarix\n" +
            "Telarix\n" +
            "Telarix\n" +
            "Telecall\n" +
            "Telecall\n" +
            "Telecall\n" +
            "Telecall\n" +
            "Telecom Argentina\n" +
            "Telecom Business Group SRL\n" +
            "Telefonica Global Solutions\n" +
            "Telefonica International Wholesale Services\n" +
            "Telefónica International Wholesale Services\n" +
            "Telefónica International Wholesale Services\n" +
            "Telefónica International Wholesale Services\n" +
            "Telefónica International Wholesale Services\n" +
            "Telekom Slovenije\n" +
            "TELEKOM SLOVENIJE D.D.\n" +
            "Telenor\n" +
            "Telenor\n" +
            "TELES AG\n" +
            "TeleSign\n" +
            "TeleSign\n" +
            "TeleSign\n" +
            "TeleSign\n" +
            "Telintel\n" +
            "TELINTEL\n" +
            "Telintel\n" +
            "TELINTEL\n" +
            "The Hub\n" +
            "Titan International Wholesale\n" +
            "Titan International Wholesale\n" +
            "Titan International Wholesale Inc.\n" +
            "TNZI\n" +
            "TNZI\n" +
            "Tree Telecom\n" +
            "TREE TELECOM S.L.\n" +
            "TREE TELECOM S.L.\n" +
            "Turk Telekom International\n" +
            "Turk Telekom International\n" +
            "Twilio Inc.\n" +
            "TWT S.p.A.\n" +
            "tyntec\n" +
            "tyntec\n" +
            "tyntec\n" +
            "UBIQUITY SRL\n" +
            "Uno Communications Inc\n" +
            "Uno Communications Spa\n" +
            "UPM TECHNOLOGY GMBH\n" +
            "UPM Telecom\n" +
            "UPM Telecom\n" +
            "UPM Telecom\n" +
            "US Matrix\n" +
            "USMatrix\n" +
            "USMatrix\n" +
            "USMatrix\n" +
            "VAZQ COMMUNICATIONS Inc.\n" +
            "VAZQ COMMUNICATIONS Inc.\n" +
            "VAZQ COMMUNICATIONS INC.\n" +
            "Veoo\n" +
            "Veoo Ltd\n" +
            "Veoo Ltd\n" +
            "Veoo Ltd\n" +
            "Veoo Ltd\n" +
            "Verizon\n" +
            "Verizon\n" +
            "VERSCOM CARRIER VOICE\n" +
            "Verscom Carrier Voice\n" +
            "Verscom Carrier Voice\n" +
            "Verscom Solutions\n" +
            "Verscom Solutions\n" +
            "VertexSMS\n" +
            "VertexSMS\n" +
            "VertexSMS\n" +
            "VIAHUB\n" +
            "VIAHUB\n" +
            "Vianett AS\n" +
            "Viber\n" +
            "Vodafone Carrier Serivces\n" +
            "Vodafone Carrier Serivces\n" +
            "Vodafone Carrier Serivces\n" +
            "Vodafone Carrier Services\n" +
            "VoIP Capital International\n" +
            "VoIP Capital International\n" +
            "VOIPSHOP Telecommunications\n" +
            "Voipville S.L.\n" +
            "Voipville S.L.\n" +
            "Vox Carrier\n" +
            "Voxbeam Telecommunications Inc.\n" +
            "Voxbone\n" +
            "VoxBridge\n" +
            "VoxBridge\n" +
            "VoxBridge\n" +
            "VR TELECOM\n" +
            "VR TELECOM, S.L.\n" +
            "VR TELECOM, S.L.\n" +
            "VR TELECOM, S.L.\n" +
            "VR TELECOM, S.L.\n" +
            "VueTel Italia\n" +
            "VueTel Italia\n" +
            "WANATEL\n" +
            "WaveCrest\n" +
            "WaveCrest\n" +
            "Wavetel Ltd.\n" +
            "Westmount Telecom\n" +
            "Whatever Mobile\n" +
            "Whatever Mobile GmbH\n" +
            "Wholesale Congress Series\n" +
            "WIC WorldCom International Communications\n" +
            "WIC WorldCom International Communications\n" +
            "XOtel\n" +
            "XOtel\n" +
            "YUBOTO LTD\n" +
            "YUBOTO LTD\n" +
            "42com Telecommunication GmbH\n" +
            "42com Telecommunication GmbH\n" +
            "4Carriers International\n" +
            "5g Future Inc.\n" +
            "A-Tono\n" +
            "A.A.Smartcomtech USA\n" +
            "A.A.Smartcomtech USA\n" +
            "Abison Telecom\n" +
            "ACTIVATEL SA\n" +
            "ADC TELECOM\n" +
            "ADC TELECOM\n" +
            "ADC TELECOM\n" +
            "ADC TELECOM\n" +
            "Advise\n" +
            "Advise\n" +
            "Afinna One\n" +
            "Afinna One\n" +
            "Agile Telecom S.p.A.\n" +
            "Agile Telecom S.p.A.\n" +
            "Akton d.o.o.\n" +
            "Akton d.o.o.\n" +
            "Alarislabs\n" +
            "Alarislabs\n" +
            "AlkaIP Telecom\n" +
            "Alnifolia Ltd\n" +
            "Americatel Communications S.L.\n" +
            "Americatel Communications S.L.\n" +
            "Americatel Communications S.L.\n" +
            "Americatel Communications S.L.\n" +
            "Americatel Communications S.L.\n" +
            "Antwerp Technologies\n" +
            "Apelby Communications\n" +
            "Apelby Communications\n" +
            "Api Connect\n" +
            "Api Connect\n" +
            "Api Connect\n" +
            "ArpuPlus\n" +
            "AVyS Telecom\n" +
            "AVyS Telecom\n" +
            "AVyS Telecom\n" +
            "AVyS Telecom\n" +
            "Bankai Group\n" +
            "Bankai Group\n" +
            "Baway\n" +
            "BBT Voice Pvt Ltd\n" +
            "Beepsend AB\n" +
            "Bezeq international\n" +
            "BFT Telecom,LLC /Brasilfone\n" +
            "BICS\n" +
            "BICS\n" +
            "BICS\n" +
            "BLUEPHONE\n" +
            "Bongo Live\n" +
            "Bongo Live\n" +
            "Bridgevoice Inc\n" +
            "BROADNET TECHNOLOGIES\n" +
            "BT Global Telecom Markets\n" +
            "BT Global Telecom Markets\n" +
            "BT Global Telecom Markets\n" +
            "BT Global Telecom Markets\n" +
            "BTS - Business Telecommunications Services\n" +
            "C3ntro Telecom\n" +
            "Call3.pl\n" +
            "CallCaribe\n" +
            "CallCaribe\n" +
            "CallCaribe INC\n" +
            "Callvox\n" +
            "Callvox\n" +
            "Callvox\n" +
            "Capital City Service\n" +
            "Carrier Italia Srl\n" +
            "Carrier Italia Srl\n" +
            "Cellfind\n" +
            "Cenbong Data Limited\n" +
            "Cequens\n" +
            "China Telecom Global\n" +
            "China Telecom Global\n" +
            "Citic Telecom\n" +
            "Citic Telecom\n" +
            "Comunica It Services SA\n" +
            "Cronos Group Limited\n" +
            "Cytech Mobile\n" +
            "Data Access Solutions Inc.\n" +
            "Data Access Solutions Inc.\n" +
            "Datora Telecom\n" +
            "Dialogue Group\n" +
            "Digitalk\n" +
            "DIMOCO Messaging\n" +
            "DIMOCO Messaging\n" +
            "DIMOCO Messaging GmbH\n" +
            "DIMOCO Messaging GmbH\n" +
            "Directo.com\n" +
            "Directo.com\n" +
            "Directo.com\n" +
            "Ecocarrier Inc.\n" +
            "Eklip Telecom\n" +
            "Encore Telecom\n" +
            "Esteria SIA\n" +
            "Esteria SIA\n" +
            "Etelix Group\n" +
            "Etelix.com USA\n" +
            "Evolution Telecom Limited\n" +
            "Evolution Telecom Limited\n" +
            "Evolution Telecom Limited\n" +
            "EVOX TRADING\n" +
            "Exridge Pte Ltd\n" +
            "Fone.es\n" +
            "Fone.es\n" +
            "Fone.es\n" +
            "Fone.es\n" +
            "FOREST INTERACTIVE SDN BHD\n" +
            "Fortytwo\n" +
            "Fortytwo\n" +
            "Fortytwo\n" +
            "Fortytwo\n" +
            "G2N Telecom\n" +
            "Global Voice Telecom Limited\n" +
            "Globe Teleservices Limited\n" +
            "GM Telecom Corp\n" +
            "Go2Tel\n" +
            "GREENSATELLITE, LDA\n" +
            "Grupo Communicate\n" +
            "Grupo Communicate\n" +
            "GTX GmbH\n" +
            "GTX GmbH\n" +
            "Hansa Telecom SIA\n" +
            "HGC - Hutchison Global Communications Limited\n" +
            "HGC - Hutchison Global Communications\n" +
            "HORISEN AG\n" +
            "HORISEN AG\n" +
            "HUB PUSH SMS BRASIL\n" +
            "HubPush\n" +
            "iBasis\n" +
            "iBasis\n" +
            "iBasis\n" +
            "Identidad Telecom\n" +
            "Identidad Telecom\n" +
            "Identidad Telecom\n" +
            "Identidad Telecom\n" +
            "IDT Global Ltd\n" +
            "IDT Global Ltd\n" +
            "IDT Global Ltd\n" +
            "IMImobile Europe Limited\n" +
            "Impact Telecom\n" +
            "inaani pte.ltd.\n" +
            "inaani pte.ltd.\n" +
            "Infobip\n" +
            "Infobip\n" +
            "Infobip\n" +
            "Instasent Mobile Advertising SL\n" +
            "Instasent Mobile Advertising SL\n" +
            "Instasent Mobile Advertising SL\n" +
            "interactive digital media GmbH\n" +
            "interactive digital media GmbH\n" +
            "IPVOIP s.r.o.\n" +
            "IPVOIP s.r.o.\n" +
            "iQsim\n" +
            "iQsim\n" +
            "IT-DECISION LLC\n" +
            "IT-DECISION LLC\n" +
            "IT-DECISION LLC\n" +
            "IT-DECISION LLC\n" +
            "IVOICE NETWORKS PTE LTD\n" +
            "JeraSoft\n" +
            "JeraSoft\n" +
            "JET TELECOM\n" +
            "JET TELECOM\n" +
            "JET TELECOM\n" +
            "Klucz Mobile\n" +
            "Korea Telecom\n" +
            "Lanck Telecom\n" +
            "Lanck Telecom\n" +
            "Lanck Telecom\n" +
            "LANCK Telecom\n" +
            "LANCK Telecom\n" +
            "Lanck Telecom\n" +
            "Lanck Telecom\n" +
            "LANCK Telecom\n" +
            "LANCK Telecom\n" +
            "Last Mile Corp\n" +
            "Last Mile Corp\n" +
            "LATINATEL\n" +
            "Latino Communications Corp\n" +
            "LATTELECOM\n" +
            "LCRCOM\n" +
            "Lexico Telecom\n" +
            "Lexico Telecom LTD\n" +
            "Lexico Telecom LTD\n" +
            "Lleida.net\n" +
            "Lleida.net\n" +
            "Lleida.net\n" +
            "Lleida.net\n" +
            "Logik Communications\n" +
            "Logik Communications Pte Ltd\n" +
            "Magic Telecom\n" +
            "MÁSMÓVIL\n" +
            "MÁSMÓVIL\n" +
            "MÁSMÓVIL\n" +
            "MÁSMÓVIL\n" +
            "MÁSMÓVIL\n";
    static String oldCompTwo = "Michael P.\n" +
            "Rasa\n" +
            "Rokas\n" +
            "Mike\n" +
            "Kabir\n" +
            "Ihab\n" +
            "Traian\n" +
            "Nelson\n" +
            "Joosep\n" +
            "John\n" +
            "Farah\n" +
            "Tuvia\n" +
            "Nadeem\n" +
            "Ana Claro\n" +
            "Miroslava\n" +
            "Igor\n" +
            "Alla\n" +
            "GIULIA FRANCESCA\n" +
            "Janez\n" +
            "Andrea\n" +
            "Ricardo\n" +
            "Khalid Mahmmod\n" +
            "Gina Mitsou\n" +
            "Alessandro\n" +
            "Joycelyn\n" +
            "Mahmoud\n" +
            "Jovana\n" +
            "Robin\n" +
            "Max\n" +
            "Hugo\n" +
            "Elwin\n" +
            "Alex\n" +
            "Ollie\n" +
            "Andrew\n" +
            "Kurt\n" +
            "Shanka\n" +
            "VINCENZO\n" +
            "WALTER\n" +
            "Eykis\n" +
            "Alexandru\n" +
            "Mihnea Dorian\n" +
            "Gherman\n" +
            "Adam\n" +
            "Natalia\n" +
            "Jose María\n" +
            "Frederic\n" +
            "Joana\n" +
            "Marina\n" +
            "AKM Shahidul\n" +
            "Nuria\n" +
            "Maria\n" +
            "Nejla\n" +
            "Vlaho\n" +
            "Kurt\n" +
            "Cesar Feito\n" +
            "Giovanni\n" +
            "Javier\n" +
            "Duncan\n" +
            "Craig\n" +
            "Frederic\n" +
            "Ignacio\n" +
            "Helena\n" +
            "Otilia\n" +
            "Caroline\n" +
            "Marta\n" +
            "David\n" +
            "Alejandro\n" +
            "Abderrahim\n" +
            "Mengqin\n" +
            "Izabela\n" +
            "Luis Alberto\n" +
            "Alfonso\n" +
            "Agnès\n" +
            "Piotr\n" +
            "José Carlos\n" +
            "David\n" +
            "Ismael\n" +
            "Jose Abraham\n" +
            "Efi\n" +
            "Babis\n" +
            "Maria\n" +
            "Yusuf\n" +
            "Arun\n" +
            "Maickel\n" +
            "Lionel\n" +
            "Paul\n" +
            "Rick\n" +
            "Margaret\n" +
            "Andrea\n" +
            "Fabio\n" +
            "DANIEL\n" +
            "Mike\n" +
            "Annie\n" +
            "Madlen\n" +
            "Rita\n" +
            "Alexandra Eugenia\n" +
            "Alex\n" +
            "Marina\n" +
            "Michel\n" +
            "Bachir\n" +
            "Tony\n" +
            "Allison\n" +
            "DANIELE\n" +
            "Mical\n" +
            "Claudia\n" +
            "Jackov\n" +
            "Quazi Mohibul\n" +
            "Robert-Daniel\n" +
            "Rahul\n" +
            "Rajdip\n" +
            "Jeroen\n" +
            "James\n" +
            "Simon\n" +
            "Philippe\n" +
            "Lester\n" +
            "Arun\n" +
            "Artem\n" +
            "\n" +
            "Igor\n" +
            "Mathieu\n" +
            "Veronika\n" +
            "Ecaterina\n" +
            "Prashant\n" +
            "Rajesh\n" +
            "Darshan\n" +
            "Anand\n" +
            "Jacques\n" +
            "Riyaz\n" +
            "Sandeep\n" +
            "MUSA\n" +
            "MOHAMMAD HOSSEIN\n" +
            "EBRU\n" +
            "LIUDMILA\n" +
            "SERTAC\n" +
            "FATIH\n" +
            "JAMES\n" +
            "DENIZ\n" +
            "VALERIA\n" +
            "Radu\n" +
            "Filip\n" +
            "Oxana\n" +
            "Laurent\n" +
            "Sergio\n" +
            "Alfredo\n" +
            "Carla\n" +
            "Daniele\n" +
            "Radu\n" +
            "Bogdan\n" +
            "PANKAJ G\n" +
            "\n" +
            "\n" +
            "Aniketh\n" +
            "Ashish\n" +
            "Shivam\n" +
            "Bhagath\n" +
            "Bilal\n" +
            "\n" +
            "SEBASTIAN\n" +
            "JORGE\n" +
            "Catalin\n" +
            "Adriana\n" +
            "Alexandru\n" +
            "Erick\n" +
            "Sophia\n" +
            "Denys\n" +
            "Juan Pablo\n" +
            "Jitka\n" +
            "Michael\n" +
            "Raghid W.\n" +
            "Bilal\n" +
            "Helmut Christian\n" +
            "Duncan\n" +
            "Stefano\n" +
            "Janis\n" +
            "Eishan\n" +
            "VIVEK\n" +
            "Andrius\n" +
            "Natalija\n" +
            "Luciano\n" +
            "Tucker\n" +
            "Anthony\n" +
            "Wolfram\n" +
            "Allan\n" +
            "Angelo\n" +
            "Pedro\n" +
            "Firton\n" +
            "Federico\n" +
            "Andres\n" +
            "Marcos\n" +
            "Carlos\n" +
            "Marina\n" +
            "Iñaki\n" +
            "Alberto\n" +
            "Alejandro\n" +
            "Tanja\n" +
            "Jasmina\n" +
            "Jennifer\n" +
            "Tina\n" +
            "Marco\n" +
            "Luka\n" +
            "Bojan\n" +
            "Tijana\n" +
            "Dragan\n" +
            "Juan Camilo\n" +
            "Crystal\n" +
            "Milica\n" +
            "Dimitris\n" +
            "Inna\n" +
            "Razvan\n" +
            "Alina\n" +
            "Catalin\n" +
            "RICHARD\n" +
            "MATTHEW\n" +
            "Felipe\n" +
            "VALENTINA\n" +
            "IULIA\n" +
            "Csaba\n" +
            "Istvan\n" +
            "Carl\n" +
            "Roberta\n" +
            "Tom\n" +
            "Tom\n" +
            "Greg\n" +
            "DARIO LEOPOLDO\n" +
            "Alina\n" +
            "Carlo\n" +
            "Thomas\n" +
            "Liubimova\n" +
            "Ramona\n" +
            "Javier\n" +
            "Stewart\n" +
            "Linda LW.\n" +
            "Billy\n" +
            "Yasser\n" +
            "Nare\n" +
            "Nune\n" +
            "Maro\n" +
            "Hasan\n" +
            "Axel\n" +
            "Mark\n" +
            "Katarina\n" +
            "Ignacio\n" +
            "Chris\n" +
            "Neil\n" +
            "KEMAL\n" +
            "Bedii\n" +
            "\n" +
            "Bulent\n" +
            "Alper Tunga\n" +
            "Simonas\n" +
            "Laima\n" +
            "Vytautas\n" +
            "Maja\n" +
            "Iva\n" +
            "Arild\n" +
            "Ron\n" +
            "Ravinder\n" +
            "Susana\n" +
            "Juan Jose\n" +
            "Erik\n" +
            "Dean\n" +
            "Saul\n" +
            "Lilit\n" +
            "Raffaele\n" +
            "Luca\n" +
            "MONICA\n" +
            "Oldenn\n" +
            "Lucia\n" +
            "Hakobyan\n" +
            "Arustamyan\n" +
            "Baghdasaryan\n" +
            "Stanislav\n" +
            "MICHELLE\n" +
            "SAJJAD\n" +
            "LYLIA\n" +
            "ELVINA\n" +
            "Francesco\n" +
            "Roberta\n" +
            "Youssef\n" +
            "Peter\n" +
            "Carola\n" +
            "Usman A\n" +
            "Bella\n" +
            "Ben\n" +
            "Timothy\n" +
            "Santiago\n" +
            "Arsen\n" +
            "Eleonora\n" +
            "Iryna\n" +
            "Kseniia\n" +
            "ANDREAS\n" +
            "APOSTOLIS\n" +
            "Ana Maria\n" +
            "Catalina\n" +
            "Leszek\n" +
            "Dmitry\n" +
            "Orazio\n" +
            "Adi\n" +
            "Alex\n" +
            "Marcelo\n" +
            "Ollivier\n" +
            "Lorenzo\n" +
            "Alessandro\n" +
            "Enrique\n" +
            "LUCIANO\n" +
            "Massimo\n" +
            "Francesco\n" +
            "Massimo\n" +
            "Sebastiano\n" +
            "Dario\n" +
            "Giovanni\n" +
            "Matej\n" +
            "PETER\n" +
            "Irene\n" +
            "Andrey\n" +
            "David\n" +
            "Panagiotis\n" +
            "Mauricio\n" +
            "Joaquín\n" +
            "Manuel\n" +
            "Lina Maria\n" +
            "Tomas\n" +
            "Mohammad\n" +
            "Gustav\n" +
            "Petra\n" +
            "Flavia\n" +
            "Janis\n" +
            "Stefano\n" +
            "Sherif\n" +
            "Saveliy\n" +
            "Sadrin\n" +
            "Pedro\n" +
            "Lilia\n" +
            "Chanderhas\n" +
            "Adil\n" +
            "Inna\n" +
            "Rahul\n" +
            "Evelina\n" +
            "Aviad\n" +
            "Hugo\n" +
            "Christophe\n" +
            "Elena\n" +
            "Alexander\n" +
            "CARLOS\n" +
            "Taha\n" +
            "Rasha\n" +
            "Manoj\n" +
            "RABIH\n" +
            "Aldo\n" +
            "Arturo\n" +
            "Estela\n" +
            "Claudia\n" +
            "Victor\n" +
            "Abraham\n" +
            "Szymon\n" +
            "Fernando\n" +
            "Pablo\n" +
            "Ivan\n" +
            "Ben\n" +
            "Ignacio\n" +
            "Nick\n" +
            "Inna\n" +
            "Alberto\n" +
            "Giuseppe\n" +
            "Niel\n" +
            "Mingxu\n" +
            "Nadine\n" +
            "Nathan\n" +
            "Polly\n" +
            "Athanasia (Nassia)\n" +
            "Benny\n" +
            "Laura\n" +
            "Uri\n" +
            "Yorgos\n" +
            "Idin\n" +
            "Irina\n" +
            "Daniela\n" +
            "Justin\n" +
            "Giovanni\n" +
            "Michael\n" +
            "Anton\n" +
            "Matthias\n" +
            "Anton\n" +
            "David\n" +
            "Beatriz\n" +
            "Gloria\n" +
            "Mohamed\n" +
            "Ahmad\n" +
            "Dragos\n" +
            "Konstantins\n" +
            "Andrejs\n" +
            "Leandro\n" +
            "Juan Carlos\n" +
            "Yevhen\n" +
            "Sabuhi\n" +
            "Andrii\n" +
            "Romain\n" +
            "Pietro\n" +
            "Alejandro\n" +
            "Rafael\n" +
            "Alejandro\n" +
            "Guillermo\n" +
            "Johary\n" +
            "Adrian\n" +
            "Chrystyna\n" +
            "Giulia\n" +
            "Neil\n" +
            "Alceu\n" +
            "Mushfique\n" +
            "Vikrant\n" +
            "Gonzalo\n" +
            "Francesca\n" +
            "Pavel\n" +
            "Carlos\n" +
            "Estrella\n" +
            "Oliver\n" +
            "Frank\n" +
            "Tetiana\n" +
            "Irfan\n" +
            "Roberto\n" +
            "Fabrizio\n" +
            "Miguel\n" +
            "Alessandro\n" +
            "Oriol\n" +
            "Jorge\n" +
            "Xavier\n" +
            "Julian\n" +
            "Gabriel\n" +
            "Carolina\n" +
            "Maria Teresa\n" +
            "Luisa\n" +
            "Arie\n" +
            "Claudia\n" +
            "Jason\n" +
            "Jason\n" +
            "Timba\n" +
            "M. Rezaul\n" +
            "Monnujan\n" +
            "Goran\n" +
            "Tea\n" +
            "Irina\n" +
            "Oscar\n" +
            "Marta\n" +
            "Mario\n" +
            "Lars\n" +
            "Bertrand\n" +
            "Svetlana\n" +
            "Elena\n" +
            "Yvon\n" +
            "Xavier\n" +
            "Sergii\n" +
            "Denys\n" +
            "Dmitriy\n" +
            "Anna\n" +
            "Homesh\n" +
            "Mike\n" +
            "Vitaly\n" +
            "CLAUDIO\n" +
            "ALEJANDRO\n" +
            "CARLOS\n" +
            "Denis\n" +
            "Junkyung\n" +
            "Alena\n" +
            "Dmitry\n" +
            "Alexey\n" +
            "Nataliya\n" +
            "Dmitry\n" +
            "Anastasia\n" +
            "Marharyta\n" +
            "Andrey\n" +
            "Margarita\n" +
            "Alexandru\n" +
            "Gabriel\n" +
            "Sandra\n" +
            "Jorge\n" +
            "Martins\n" +
            "Erika\n" +
            "Augusto\n" +
            "Erick\n" +
            "Augusto\n" +
            "Sisco\n" +
            "Yolanda\n" +
            "Beatriz\n" +
            "Alejandro\n" +
            "Noaman\n" +
            "James\n" +
            "Ryan\n" +
            "OSCAR\n" +
            "NURIA\n" +
            "JESÚS\n" +
            "ANGEL\n" +
            "RAMÓN\n";
    static String oldCompThree = "Knobel\n" +
            "Šaltenė\n" +
            "Deksnys\n" +
            "Charlesworth\n" +
            "Ahmed\n" +
            "Matta\n" +
            "Visinescu\n" +
            "Villalona\n" +
            "Pintsaar\n" +
            "Tong\n" +
            "Royer\n" +
            "Edelman\n" +
            "Ladha\n" +
            "Porto\n" +
            "Kucharova\n" +
            "Skvortsov\n" +
            "Drozdova\n" +
            "DEL MASTRO\n" +
            "Snoj\n" +
            "Salini\n" +
            "Bastos\n" +
            "Mansour\n" +
            "Davis\n" +
            "Giacobazzi\n" +
            "Lee\n" +
            "Abou Zeid\n" +
            "Dukic\n" +
            "Sullivan\n" +
            "Dudley\n" +
            "Vizcarra\n" +
            "Machado\n" +
            "Economon\n" +
            "Gibbons\n" +
            "Ward\n" +
            "Sfiligoi\n" +
            "Silva\n" +
            "LA BARBERA\n" +
            "IASIELLO\n" +
            "Sambrano\n" +
            "Enache\n" +
            "Prunescu\n" +
            "Alin Valentin\n" +
            "Barakat\n" +
            "Bubnovskaia\n" +
            "Ortiz\n" +
            "Missotten\n" +
            "Ferreira\n" +
            "Dulčić\n" +
            "Islam\n" +
            "Pallarés\n" +
            "Marmaneu\n" +
            "Bunic\n" +
            "Kaminski\n" +
            "Bonello\n" +
            "Otero\n" +
            "Benini\n" +
            "Sainz\n" +
            "Morton\n" +
            "Rutherford\n" +
            "Sentuc\n" +
            "Sáez\n" +
            "Laporte\n" +
            "Anton\n" +
            "Varley\n" +
            "Gabanska\n" +
            "Moreno\n" +
            "Fonseca\n" +
            "Drriji\n" +
            "Chen\n" +
            "Kamińska\n" +
            "Santiago\n" +
            "Gonzalez\n" +
            "Pégorier\n" +
            "Mikołajczyk\n" +
            "Dobarro López\n" +
            "Losada\n" +
            "Lopez\n" +
            "Méndez\n" +
            "Kiriazi\n" +
            "Petrogiannakis\n" +
            "Labi\n" +
            "Vahed\n" +
            "Jethi\n" +
            "Abdou\n" +
            "Rayon\n" +
            "Baaij\n" +
            "Knight\n" +
            "McNerney\n" +
            "Beneforti\n" +
            "Preda\n" +
            "MENDOZA\n" +
            "Vazquez\n" +
            "Gevorgyan\n" +
            "Saribekyan\n" +
            "Lopes Taborda Vaz\n" +
            "Dias Ferreira\n" +
            "Bisio\n" +
            "Kireja\n" +
            "Yazbeck\n" +
            "Sadaka\n" +
            "Gonzalez\n" +
            "Clarke\n" +
            "POERIO\n" +
            "Yemane\n" +
            "Lumini\n" +
            "Mayurov\n" +
            "Islam\n" +
            "Ciuca\n" +
            "Pandey\n" +
            "Kumar Gupta\n" +
            "Weijenberg\n" +
            "Matthews\n" +
            "Gregory\n" +
            "Oliveira\n" +
            "Dsouza\n" +
            "Pradhiph\n" +
            "Volobuiev\n" +
            "\n" +
            "Godovanets\n" +
            "Deslauriers\n" +
            "Vankevich\n" +
            "Terzi\n" +
            "Kumar\n" +
            "Pal\n" +
            "Mujumdar\n" +
            "Tawari\n" +
            "KAS\n" +
            "Shaikh\n" +
            "Anturkar\n" +
            "RAD\n" +
            "NOORANI TAGHIDIZAJ\n" +
            "DUKHOPEL\n" +
            "LITOVCHENKO\n" +
            "VARDAR\n" +
            "TURAN\n" +
            "GWILLIM\n" +
            "OZKUS\n" +
            "NAKONECHNIKOVA\n" +
            "Sovaiala\n" +
            "Stanczyk\n" +
            "Manyaeva\n" +
            "Manso\n" +
            "Ramos\n" +
            "Andreozzi\n" +
            "Race\n" +
            "Russo\n" +
            "Iliescu\n" +
            "Dinu\n" +
            "BHAGCHANDANI\n" +
            "\n" +
            "\n" +
            "Jain\n" +
            "Agarwal\n" +
            "Prasad\n" +
            "Gopal\n" +
            "Khazem\n" +
            "\n" +
            "TARDY\n" +
            "ECAY\n" +
            "Sporis\n" +
            "Ungureanu\n" +
            "Stan\n" +
            "Almonte\n" +
            "Benabou\n" +
            "Buhay\n" +
            "Jiménez\n" +
            "Ferriova\n" +
            "Schneider\n" +
            "Charara\n" +
            "Badawi\n" +
            "Stricker\n" +
            "Land\n" +
            "Sessa\n" +
            "Jakobsons\n" +
            "Gupta\n" +
            "CHAND\n" +
            "Danilaitis\n" +
            "Rekel\n" +
            "Garavaglia\n" +
            "Davidson\n" +
            "Pireddu\n" +
            "Thielen\n" +
            "Ajuz\n" +
            "Paiva\n" +
            "Chueire\n" +
            "Acha\n" +
            "Jalón\n" +
            "Martinez\n" +
            "Staffolani\n" +
            "Piñango\n" +
            "Martínez\n" +
            "Iraeta Solana\n" +
            "González Ortega\n" +
            "Hernández Colino\n" +
            "Luketina\n" +
            "Glavač Anžin\n" +
            "Strømme\n" +
            "Petrovik\n" +
            "Spigarelli\n" +
            "Perisic\n" +
            "Savic\n" +
            "Djokic\n" +
            "Ilic\n" +
            "Osorio\n" +
            "Enriquez\n" +
            "Gruden\n" +
            "Asaridis\n" +
            "Ovdienko\n" +
            "Constantin\n" +
            "Filip\n" +
            "Neacsea\n" +
            "MARVIN\n" +
            "SCOTT\n" +
            "de Ancos\n" +
            "VARABIEV\n" +
            "MASLOVSKA\n" +
            "Fulop\n" +
            "Somogyi\n" +
            "Powell\n" +
            "Iori\n" +
            "Posti\n" +
            "Posti\n" +
            "Henderson\n" +
            "CALOGERO\n" +
            "Caraus\n" +
            "Capacci\n" +
            "Sorgalla\n" +
            "Liudmila\n" +
            "Benson\n" +
            "Mendoza\n" +
            "Brennan\n" +
            "Chung\n" +
            "Souto Maior\n" +
            "Hamid\n" +
            "Haroyan\n" +
            "Manukyan\n" +
            "Hakobjanyan\n" +
            "Büyükasik\n" +
            "Bernhard\n" +
            "Henstone\n" +
            "Velickovic\n" +
            "Gali\n" +
            "Hills\n" +
            "MCMahon\n" +
            "KÜÇÜK\n" +
            "ATASAGUN\n" +
            "\n" +
            "Tuncel\n" +
            "BURAK\n" +
            "Ridzvanavičius\n" +
            "Vasiļenko\n" +
            "Basys\n" +
            "Vrbanić\n" +
            "Marić\n" +
            "Bakkland\n" +
            "Shmueli\n" +
            "Lota\n" +
            "Calvo Redondo\n" +
            "Gomez\n" +
            "Sluijtman\n" +
            "Rosenthal\n" +
            "Gewer\n" +
            "Ayvazyan\n" +
            "Maddaluno\n" +
            "Casagrande\n" +
            "LUNGU\n" +
            "Sylvert\n" +
            "Vorano\n" +
            "Liana\n" +
            "Marine\n" +
            "Sona\n" +
            "Kostuykovskiy\n" +
            "BUGNER\n" +
            "ANWAR\n" +
            "SALIKOVA\n" +
            "TIMERBAEVA\n" +
            "Costantini\n" +
            "Garofalo\n" +
            "FADILI\n" +
            "Morris\n" +
            "Cespedes\n" +
            "Azhar\n" +
            "Barseghyan\n" +
            "Phoenix\n" +
            "Arell\n" +
            "Marquez\n" +
            "Hambardzumyan\n" +
            "Karapetyan\n" +
            "Chub\n" +
            "Gurova\n" +
            "CONSTANTINIDES\n" +
            "IOAKEIM\n" +
            "Ion\n" +
            "Bica\n" +
            "Szczech\n" +
            "Stafeev\n" +
            "Granato\n" +
            "Peleg\n" +
            "Berkovsky\n" +
            "Acosta y Lara\n" +
            "ANNEIX\n" +
            "Galletti\n" +
            "Sabato\n" +
            "Rodriguez\n" +
            "DI STEFANO\n" +
            "Bagnoli\n" +
            "Cappabianca\n" +
            "Lucera\n" +
            "Dionisi\n" +
            "Tumiati\n" +
            "Polesel\n" +
            "Zgombic\n" +
            "MILIČ\n" +
            "Ustinova\n" +
            "Anikin\n" +
            "Baena\n" +
            "Afchoudias\n" +
            "Garcia\n" +
            "González  Gomez\n" +
            "Garcia Manso\n" +
            "Pulgarin Osorio\n" +
            "Valladares Loreto\n" +
            "Yassine\n" +
            "Koutnik\n" +
            "Kadacikova\n" +
            "Miceli\n" +
            "Lietavietis\n" +
            "Antichi\n" +
            "Nessim\n" +
            "Sumenov\n" +
            "Mihail\n" +
            "Morfi\n" +
            "Antoniuk\n" +
            "Rana\n" +
            "Dua\n" +
            "Hodinitu\n" +
            "Sharma (Ray)\n" +
            "Storm\n" +
            "Odeser\n" +
            "Zampieri\n" +
            "Pirson\n" +
            "Ivashchenko\n" +
            "Topikha\n" +
            "SANZ NAVARRETE\n" +
            "Jiwaji\n" +
            "Kamal\n" +
            "Jain\n" +
            "ZUBAIDI\n" +
            "Martinetto\n" +
            "Martin Martin\n" +
            "Ruiz Vicente\n" +
            "Vegni\n" +
            "Lopez\n" +
            "Smeke\n" +
            "Lasek\n" +
            "Rodriguez\n" +
            "Sedan\n" +
            "Cables\n" +
            "Farzam\n" +
            "Lopez Pelegrin\n" +
            "Hovan\n" +
            "Arutiunova\n" +
            "Leone\n" +
            "Luciano\n" +
            "Barnard\n" +
            "Zhang\n" +
            "Chouha\n" +
            "Li\n" +
            "Xu\n" +
            "Skoulikariti\n" +
            "Chan\n" +
            "Diana\n" +
            "Gaoni\n" +
            "Saslis\n" +
            "Rangchi\n" +
            "Pozharska\n" +
            "Baptista\n" +
            "Kempel\n" +
            "Tesauro\n" +
            "Hagen\n" +
            "Chmelar\n" +
            "Höllerl\n" +
            "Chmelar\n" +
            "Jassan\n" +
            "Silva\n" +
            "Alvarez\n" +
            "Warwani\n" +
            "Daamoush\n" +
            "Necula\n" +
            "Ozerovs\n" +
            "Borisenoks\n" +
            "Iglesias\n" +
            "López Silva\n" +
            "Petkov\n" +
            "Karimov\n" +
            "Skorikov\n" +
            "Boulet\n" +
            "Scatigna\n" +
            "Garrido\n" +
            "Dominguez Peña\n" +
            "Castellano\n" +
            "Pastor García\n" +
            "Bin Mustapha\n" +
            "Gatt\n" +
            "Krechtiak\n" +
            "Sansone\n" +
            "Gerardi\n" +
            "Cheuiche\n" +
            "Manzoor\n" +
            "Kumar\n" +
            "Alvarez Comotti\n" +
            "Degl' Innocenti\n" +
            "Yelshyn\n" +
            "Gayangos\n" +
            "Valido\n" +
            "Zabel\n" +
            "Tüting\n" +
            "Polishchuk\n" +
            "Abubaid\n" +
            "Kourchenko\n" +
            "Salanitri\n" +
            "Cabañas\n" +
            "Ribas\n" +
            "Arranz\n" +
            "Hernandez-Renner\n" +
            "Primo\n" +
            "Bryan\n" +
            "Sanchez\n" +
            "Montoya\n" +
            "Sanchez\n" +
            "Sanchez\n" +
            "Ferris\n" +
            "de los Reyes\n" +
            "Chu\n" +
            "Wemyss\n" +
            "Bimont\n" +
            "Hassan\n" +
            "Nargis\n" +
            "Peresa\n" +
            "Olujic\n" +
            "Pacic\n" +
            "Moreno\n" +
            "Jiménez\n" +
            "Torija\n" +
            "Korbel\n" +
            "Charvoz\n" +
            "Solovyeva\n" +
            "Tikhanova\n" +
            "Le Gall\n" +
            "Lepage\n" +
            "Diachenko\n" +
            "Shkarupa\n" +
            "Chaurov\n" +
            "Iefimenko\n" +
            "Balu\n" +
            "Stukalin\n" +
            "Skoblia\n" +
            "FEIMBLATT\n" +
            "LABRA\n" +
            "CADENAS\n" +
            "Morozov\n" +
            "Lee\n" +
            "Borisova\n" +
            "Antonov\n" +
            "Yanson\n" +
            "Abashina\n" +
            "Strelkov\n" +
            "Ivanets\n" +
            "Shamko\n" +
            "Gribov\n" +
            "Shamko\n" +
            "Dragomir\n" +
            "Costea\n" +
            "Zabludovich\n" +
            "Lastra\n" +
            "Krievans\n" +
            "Bustamante\n" +
            "Barreda\n" +
            "Paz\n" +
            "Cardenas\n" +
            "Sapena\n" +
            "Serena Larramona\n" +
            "Garcia Torre\n" +
            "García-Castrillón Xam-Mar\n" +
            "Shaikh\n" +
            "Mackenzie\n" +
            "Rapolti\n" +
            "MELERO\n" +
            "ZURRÓN\n" +
            "SANZ\n" +
            "ESCANCIANO\n" +
            "GARCÍA\n";


    private static List<String> getListOfStrings(String text) {
        List<String> result = new ArrayList<>();
        String[] arStrings = text.split("\\n");
        for (String s : arStrings) {
            result.add(s.trim());
        }
        return result;
    }

    private static List<LineEntry> makeEntryListFromStringsLists(Status status, String... strings) {
        int length = 0;
        int column = 0;
        List<LineEntry> result = new ArrayList<>();
        for (String s : strings) {
            List<String> list = getListOfStrings(s);
            column++;
            if (length ==0) {
                length = list.size(); }
            else if (list.size() != length) {
                System.out.println("Wrong number of rows in column " + column);
                break;
            }
            int index = 0;
            for (String listString : list) {

                if (column == 1) {
                    result.add(new LineEntry(listString, status));
                }
                else {
                    result.get(index).addText(listString);
                }
                index++;
            }
        }
        System.out.println("Total columns processed: " + column);
        return result;
    }

    public static void main(String[] args) {


        List<LineEntry> listTest = makeEntryListFromStringsLists(Status.NEW, null);
        List<LineEntry> listNew = makeEntryListFromStringsLists(Status.NEW, newCompOne, newCompTwo, newCompThree);

        List<LineEntry> listOld = makeEntryListFromStringsLists(Status.OLD, oldCompOne, oldCompTwo, oldCompThree);
        Set<LineEntry> filtered =  new HashSet<>(listNew); //istNew.stream().distinct().collect(Collectors.toList());
        for (LineEntry entry : filtered) {
            if (listOld.contains(entry)) {
                entry.setStatus(Status.OLD);
            }
        }

        listOld.stream().distinct().filter(p -> !listNew.contains(p)).forEach(p -> { p.setStatus(Status.DEL); filtered.add(p); });

        System.out.println("Combined list:");
        for (LineEntry entry : filtered) {
            if (entry.getStatus() == Status.NEW) {
            System.out.println(entry);}
        }
    }
}
