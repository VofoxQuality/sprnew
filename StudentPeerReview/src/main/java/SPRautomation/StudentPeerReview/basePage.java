package SPRautomation.StudentPeerReview;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.opencsv.CSVReader;

public class basePage {

	public static WebDriver driver;
	public static Properties prop;
	protected String downloadPath = "C:\\Edinsightdownloads";
	int i = 0;

	private static final int TIMEOUT = 20000;
	protected String Supertent_Login_id = "te$t$uper0nh@nd";
	protected String Supertent_Login_Password = "password1!";

	// @swin : Created Constructor for Loading 'config.properties' file
	
	public basePage() {
		try {
			prop = new Properties();
			FileInputStream ip1 = new FileInputStream(System.getProperty("user.dir") + ".\\Config\\config.properties");
			prop.load(ip1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// @Parameters("browser")
	@BeforeTest(alwaysRun = true)
	public void setup1() {

		//String browser = "chrome";
		String browser = prop.getProperty("browser");
		// FirefoxProfile profile=Browser_Preference();

		// compares the value of parameter name with Firefox, if its firefox
		// then it will lauch firefox and run the script.
		if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");

			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.panel.shown", false);
			profile.setPreference("browser.download.forbid_open_with", false);
			profile.setPreference("browser.download.animateNotifications", false);
			profile.setPreference("browser.download.dir", downloadPath);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.helperApps.neverAsk.openFile", false);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/csv;text/csv;application/vnd.hzn-3d-crossword;video/3gpp;video/3gpp2;application/vnd.mseq;application/vnd.3m.post-it-notes;application/vnd.3gpp.pic-bw-large;application/vnd.3gpp.pic-bw-small;application/vnd.3gpp.pic-bw-var;application/vnd.3gp2.tcap;application/x-7z-compressed;application/x-abiword;application/x-ace-compressed;application/vnd.americandynamics.acc;application/vnd.acucobol;application/vnd.acucorp;audio/adpcm;application/x-authorware-bin;application/x-athorware-map;application/x-authorware-seg;application/vnd.adobe.air-application-installer-package+zip;application/x-shockwave-flash;application/vnd.adobe.fxp;application/pdf;application/vnd.cups-ppd;application/x-director;applicaion/vnd.adobe.xdp+xml;application/vnd.adobe.xfdf;audio/x-aac;application/vnd.ahead.space;application/vnd.airzip.filesecure.azf;application/vnd.airzip.filesecure.azs;application/vnd.amazon.ebook;application/vnd.amiga.ami;applicatin/andrew-inset;application/vnd.android.package-archive;application/vnd.anser-web-certificate-issue-initiation;application/vnd.anser-web-funds-transfer-initiation;application/vnd.antix.game-component;application/vnd.apple.installe+xml;application/applixware;application/vnd.hhe.lesson-player;application/vnd.aristanetworks.swi;text/x-asm;application/atomcat+xml;application/atomsvc+xml;application/atom+xml;application/pkix-attr-cert;audio/x-aiff;video/x-msvieo;application/vnd.audiograph;image/vnd.dxf;model/vnd.dwf;text/plain-bas;application/x-bcpio;application/octet-stream;image/bmp;application/x-bittorrent;application/vnd.rim.cod;application/vnd.blueice.multipass;application/vnd.bm;application/x-sh;image/prs.btif;application/vnd.businessobjects;application/x-bzip;application/x-bzip2;application/x-csh;text/x-c;application/vnd.chemdraw+xml;text/css;chemical/x-cdx;chemical/x-cml;chemical/x-csml;application/vn.contact.cmsg;application/vnd.claymore;application/vnd.clonk.c4group;image/vnd.dvb.subtitle;application/cdmi-capability;application/cdmi-container;application/cdmi-domain;application/cdmi-object;application/cdmi-queue;applicationvnd.cluetrust.cartomobile-config;application/vnd.cluetrust.cartomobile-config-pkg;image/x-cmu-raster;model/vnd.collada+xml;text/csv;application/mac-compactpro;application/vnd.wap.wmlc;image/cgm;x-conference/x-cooltalk;image/x-cmx;application/vnd.xara;application/vnd.cosmocaller;application/x-cpio;application/vnd.crick.clicker;application/vnd.crick.clicker.keyboard;application/vnd.crick.clicker.palette;application/vnd.crick.clicker.template;application/vn.crick.clicker.wordbank;application/vnd.criticaltools.wbs+xml;application/vnd.rig.cryptonote;chemical/x-cif;chemical/x-cmdf;application/cu-seeme;application/prs.cww;text/vnd.curl;text/vnd.curl.dcurl;text/vnd.curl.mcurl;text/vnd.crl.scurl;application/vnd.curl.car;application/vnd.curl.pcurl;application/vnd.yellowriver-custom-menu;application/dssc+der;application/dssc+xml;application/x-debian-package;audio/vnd.dece.audio;image/vnd.dece.graphic;video/vnd.dec.hd;video/vnd.dece.mobile;video/vnd.uvvu.mp4;video/vnd.dece.pd;video/vnd.dece.sd;video/vnd.dece.video;application/x-dvi;application/vnd.fdsn.seed;application/x-dtbook+xml;application/x-dtbresource+xml;application/vnd.dvb.ait;applcation/vnd.dvb.service;audio/vnd.digital-winds;image/vnd.djvu;application/xml-dtd;application/vnd.dolby.mlp;application/x-doom;application/vnd.dpgraph;audio/vnd.dra;application/vnd.dreamfactory;audio/vnd.dts;audio/vnd.dts.hd;imag/vnd.dwg;application/vnd.dynageo;application/ecmascript;application/vnd.ecowin.chart;image/vnd.fujixerox.edmics-mmr;image/vnd.fujixerox.edmics-rlc;application/exi;application/vnd.proteus.magazine;application/epub+zip;message/rfc82;application/vnd.enliven;application/vnd.is-xpr;image/vnd.xiff;application/vnd.xfdl;application/emma+xml;application/vnd.ezpix-album;application/vnd.ezpix-package;image/vnd.fst;video/vnd.fvt;image/vnd.fastbidsheet;application/vn.denovo.fcselayout-link;video/x-f4v;video/x-flv;image/vnd.fpx;image/vnd.net-fpx;text/vnd.fmi.flexstor;video/x-fli;application/vnd.fluxtime.clip;application/vnd.fdf;text/x-fortran;application/vnd.mif;application/vnd.framemaker;imae/x-freehand;application/vnd.fsc.weblaunch;application/vnd.frogans.fnc;application/vnd.frogans.ltf;application/vnd.fujixerox.ddd;application/vnd.fujixerox.docuworks;application/vnd.fujixerox.docuworks.binder;application/vnd.fujitu.oasys;application/vnd.fujitsu.oasys2;application/vnd.fujitsu.oasys3;application/vnd.fujitsu.oasysgp;application/vnd.fujitsu.oasysprs;application/x-futuresplash;application/vnd.fuzzysheet;image/g3fax;application/vnd.gmx;model/vn.gtw;application/vnd.genomatix.tuxedo;application/vnd.geogebra.file;application/vnd.geogebra.tool;model/vnd.gdl;application/vnd.geometry-explorer;application/vnd.geonext;application/vnd.geoplan;application/vnd.geospace;applicatio/x-font-ghostscript;application/x-font-bdf;application/x-gtar;application/x-texinfo;application/x-gnumeric;application/vnd.google-earth.kml+xml;application/vnd.google-earth.kmz;application/vnd.grafeq;image/gif;text/vnd.graphviz;aplication/vnd.groove-account;application/vnd.groove-help;application/vnd.groove-identity-message;application/vnd.groove-injector;application/vnd.groove-tool-message;application/vnd.groove-tool-template;application/vnd.groove-vcar;video/h261;video/h263;video/h264;application/vnd.hp-hpid;application/vnd.hp-hps;application/x-hdf;audio/vnd.rip;application/vnd.hbci;application/vnd.hp-jlyt;application/vnd.hp-pcl;application/vnd.hp-hpgl;application/vnd.yamaha.h-script;application/vnd.yamaha.hv-dic;application/vnd.yamaha.hv-voice;application/vnd.hydrostatix.sof-data;application/hyperstudio;application/vnd.hal+xml;text/html;application/vnd.ibm.rights-management;application/vnd.ibm.securecontainer;text/calendar;application/vnd.iccprofile;image/x-icon;application/vnd.igloader;image/ief;application/vnd.immervision-ivp;application/vnd.immervision-ivu;application/reginfo+xml;text/vnd.in3d.3dml;text/vnd.in3d.spot;mode/iges;application/vnd.intergeo;application/vnd.cinderella;application/vnd.intercon.formnet;application/vnd.isac.fcs;application/ipfix;application/pkix-cert;application/pkixcmp;application/pkix-crl;application/pkix-pkipath;applicaion/vnd.insors.igm;application/vnd.ipunplugged.rcprofile;application/vnd.irepository.package+xml;text/vnd.sun.j2me.app-descriptor;application/java-archive;application/java-vm;application/x-java-jnlp-file;application/java-serializd-object;text/x-java-source,java;application/javascript;application/json;application/vnd.joost.joda-archive;video/jpm;image/jpeg;video/jpeg;application/vnd.kahootz;application/vnd.chipnuts.karaoke-mmd;application/vnd.kde.karbon;aplication/vnd.kde.kchart;application/vnd.kde.kformula;application/vnd.kde.kivio;application/vnd.kde.kontour;application/vnd.kde.kpresenter;application/vnd.kde.kspread;application/vnd.kde.kword;application/vnd.kenameaapp;applicatin/vnd.kidspiration;application/vnd.kinar;application/vnd.kodak-descriptor;application/vnd.las.las+xml;application/x-latex;application/vnd.llamagraphics.life-balance.desktop;application/vnd.llamagraphics.life-balance.exchange+xml;application/vnd.jam;application/vnd.lotus-1-2-3;application/vnd.lotus-approach;application/vnd.lotus-freelance;application/vnd.lotus-notes;application/vnd.lotus-organizer;application/vnd.lotus-screencam;application/vnd.lotus-wordro;audio/vnd.lucent.voice;audio/x-mpegurl;video/x-m4v;application/mac-binhex40;application/vnd.macports.portpkg;application/vnd.osgeo.mapguide.package;application/marc;application/marcxml+xml;application/mxf;application/vnd.wolfrm.player;application/mathematica;application/mathml+xml;application/mbox;application/vnd.medcalcdata;application/mediaservercontrol+xml;application/vnd.mediastation.cdkey;application/vnd.mfer;application/vnd.mfmp;model/mesh;appliation/mads+xml;application/mets+xml;application/mods+xml;application/metalink4+xml;application/vnd.ms-powerpoint.template.macroenabled.12;application/vnd.ms-word.document.macroenabled.12;application/vnd.ms-word.template.macroenabed.12;application/vnd.mcd;application/vnd.micrografx.flo;application/vnd.micrografx.igx;application/vnd.eszigno3+xml;application/x-msaccess;video/x-ms-asf;application/x-msdownload;application/vnd.ms-artgalry;application/vnd.ms-ca-compressed;application/vnd.ms-ims;application/x-ms-application;application/x-msclip;image/vnd.ms-modi;application/vnd.ms-fontobject;application/vnd.ms-excel;application/vnd.ms-excel.addin.macroenabled.12;application/vnd.ms-excelsheet.binary.macroenabled.12;application/vnd.ms-excel.template.macroenabled.12;application/vnd.ms-excel.sheet.macroenabled.12;application/vnd.ms-htmlhelp;application/x-mscardfile;application/vnd.ms-lrm;application/x-msmediaview;aplication/x-msmoney;application/vnd.openxmlformats-officedocument.presentationml.presentation;application/vnd.openxmlformats-officedocument.presentationml.slide;application/vnd.openxmlformats-officedocument.presentationml.slideshw;application/vnd.openxmlformats-officedocument.presentationml.template;application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;application/vnd.openxmlformats-officedocument.spreadsheetml.template;application/vnd.openxmformats-officedocument.wordprocessingml.document;application/vnd.openxmlformats-officedocument.wordprocessingml.template;application/x-msbinder;application/vnd.ms-officetheme;application/onenote;audio/vnd.ms-playready.media.pya;vdeo/vnd.ms-playready.media.pyv;application/vnd.ms-powerpoint;application/vnd.ms-powerpoint.addin.macroenabled.12;application/vnd.ms-powerpoint.slide.macroenabled.12;application/vnd.ms-powerpoint.presentation.macroenabled.12;appliation/vnd.ms-powerpoint.slideshow.macroenabled.12;application/vnd.ms-project;application/x-mspublisher;application/x-msschedule;application/x-silverlight-app;application/vnd.ms-pki.stl;application/vnd.ms-pki.seccat;application/vn.visio;video/x-ms-wm;audio/x-ms-wma;audio/x-ms-wax;video/x-ms-wmx;application/x-ms-wmd;application/vnd.ms-wpl;application/x-ms-wmz;video/x-ms-wmv;video/x-ms-wvx;application/x-msmetafile;application/x-msterminal;application/msword;application/x-mswrite;application/vnd.ms-works;application/x-ms-xbap;application/vnd.ms-xpsdocument;audio/midi;application/vnd.ibm.minipay;application/vnd.ibm.modcap;application/vnd.jcp.javame.midlet-rms;application/vnd.tmobile-ivetv;application/x-mobipocket-ebook;application/vnd.mobius.mbk;application/vnd.mobius.dis;application/vnd.mobius.plc;application/vnd.mobius.mqy;application/vnd.mobius.msl;application/vnd.mobius.txf;application/vnd.mobius.daf;tex/vnd.fly;application/vnd.mophun.certificate;application/vnd.mophun.application;video/mj2;audio/mpeg;video/vnd.mpegurl;video/mpeg;application/mp21;audio/mp4;video/mp4;application/mp4;application/vnd.apple.mpegurl;application/vnd.msician;application/vnd.muvee.style;application/xv+xml;application/vnd.nokia.n-gage.data;application/vnd.nokia.n-gage.symbian.install;application/x-dtbncx+xml;application/x-netcdf;application/vnd.neurolanguage.nlu;application/vnd.na;application/vnd.noblenet-directory;application/vnd.noblenet-sealer;application/vnd.noblenet-web;application/vnd.nokia.radio-preset;application/vnd.nokia.radio-presets;text/n3;application/vnd.novadigm.edm;application/vnd.novadim.edx;application/vnd.novadigm.ext;application/vnd.flographit;audio/vnd.nuera.ecelp4800;audio/vnd.nuera.ecelp7470;audio/vnd.nuera.ecelp9600;application/oda;application/ogg;audio/ogg;video/ogg;application/vnd.oma.dd2+xml;applicatin/vnd.oasis.opendocument.text-web;application/oebps-package+xml;application/vnd.intu.qbo;application/vnd.openofficeorg.extension;application/vnd.yamaha.openscoreformat;audio/webm;video/webm;application/vnd.oasis.opendocument.char;application/vnd.oasis.opendocument.chart-template;application/vnd.oasis.opendocument.database;application/vnd.oasis.opendocument.formula;application/vnd.oasis.opendocument.formula-template;application/vnd.oasis.opendocument.grapics;application/vnd.oasis.opendocument.graphics-template;application/vnd.oasis.opendocument.image;application/vnd.oasis.opendocument.image-template;application/vnd.oasis.opendocument.presentation;application/vnd.oasis.opendocumen.presentation-template;application/vnd.oasis.opendocument.spreadsheet;application/vnd.oasis.opendocument.spreadsheet-template;application/vnd.oasis.opendocument.text;application/vnd.oasis.opendocument.text-master;application/vnd.asis.opendocument.text-template;image/ktx;application/vnd.sun.xml.calc;application/vnd.sun.xml.calc.template;application/vnd.sun.xml.draw;application/vnd.sun.xml.draw.template;application/vnd.sun.xml.impress;application/vnd.sun.xl.impress.template;application/vnd.sun.xml.math;application/vnd.sun.xml.writer;application/vnd.sun.xml.writer.global;application/vnd.sun.xml.writer.template;application/x-font-otf;application/vnd.yamaha.openscoreformat.osfpvg+xml;application/vnd.osgi.dp;application/vnd.palm;text/x-pascal;application/vnd.pawaafile;application/vnd.hp-pclxl;application/vnd.picsel;image/x-pcx;image/vnd.adobe.photoshop;application/pics-rules;image/x-pict;application/x-chat;aplication/pkcs10;application/x-pkcs12;application/pkcs7-mime;application/pkcs7-signature;application/x-pkcs7-certreqresp;application/x-pkcs7-certificates;application/pkcs8;application/vnd.pocketlearn;image/x-portable-anymap;image/-portable-bitmap;application/x-font-pcf;application/font-tdpfr;application/x-chess-pgn;image/x-portable-graymap;image/png;image/x-portable-pixmap;application/pskc+xml;application/vnd.ctc-posml;application/postscript;application/xfont-type1;application/vnd.powerbuilder6;application/pgp-encrypted;application/pgp-signature;application/vnd.previewsystems.box;application/vnd.pvi.ptid1;application/pls+xml;application/vnd.pg.format;application/vnd.pg.osasli;tex/prs.lines.tag;application/x-font-linux-psf;application/vnd.publishare-delta-tree;application/vnd.pmi.widget;application/vnd.quark.quarkxpress;application/vnd.epson.esf;application/vnd.epson.msf;application/vnd.epson.ssf;applicaton/vnd.epson.quickanime;application/vnd.intu.qfx;video/quicktime;application/x-rar-compressed;audio/x-pn-realaudio;audio/x-pn-realaudio-plugin;application/rsd+xml;application/vnd.rn-realmedia;application/vnd.realvnc.bed;applicatin/vnd.recordare.musicxml;application/vnd.recordare.musicxml+xml;application/relax-ng-compact-syntax;application/vnd.data-vision.rdz;application/rdf+xml;application/vnd.cloanto.rp9;application/vnd.jisp;application/rtf;text/richtex;application/vnd.route66.link66+xml;application/rss+xml;application/shf+xml;application/vnd.sailingtracker.track;image/svg+xml;application/vnd.sus-calendar;application/sru+xml;application/set-payment-initiation;application/set-reistration-initiation;application/vnd.sema;application/vnd.semd;application/vnd.semf;application/vnd.seemail;application/x-font-snf;application/scvp-vp-request;application/scvp-vp-response;application/scvp-cv-request;application/svp-cv-response;application/sdp;text/x-setext;video/x-sgi-movie;application/vnd.shana.informed.formdata;application/vnd.shana.informed.formtemplate;application/vnd.shana.informed.interchange;application/vnd.shana.informed.package;application/thraud+xml;application/x-shar;image/x-rgb;application/vnd.epson.salt;application/vnd.accpac.simply.aso;application/vnd.accpac.simply.imp;application/vnd.simtech-mindmapper;application/vnd.commonspace;application/vnd.ymaha.smaf-audio;application/vnd.smaf;application/vnd.yamaha.smaf-phrase;application/vnd.smart.teacher;application/vnd.svd;application/sparql-query;application/sparql-results+xml;application/srgs;application/srgs+xml;application/sml+xml;application/vnd.koan;text/sgml;application/vnd.stardivision.calc;application/vnd.stardivision.draw;application/vnd.stardivision.impress;application/vnd.stardivision.math;application/vnd.stardivision.writer;application/vnd.tardivision.writer-global;application/vnd.stepmania.stepchart;application/x-stuffit;application/x-stuffitx;application/vnd.solent.sdkm+xml;application/vnd.olpc-sugar;audio/basic;application/vnd.wqd;application/vnd.symbian.install;application/smil+xml;application/vnd.syncml+xml;application/vnd.syncml.dm+wbxml;application/vnd.syncml.dm+xml;application/x-sv4cpio;application/x-sv4crc;application/sbml+xml;text/tab-separated-values;image/tiff;application/vnd.to.intent-module-archive;application/x-tar;application/x-tcl;application/x-tex;application/x-tex-tfm;application/tei+xml;text/plain;application/vnd.spotfire.dxp;application/vnd.spotfire.sfs;application/timestamped-data;applicationvnd.trid.tpt;application/vnd.triscape.mxs;text/troff;application/vnd.trueapp;application/x-font-ttf;text/turtle;application/vnd.umajin;application/vnd.uoml+xml;application/vnd.unity;application/vnd.ufdl;text/uri-list;application/nd.uiq.theme;application/x-ustar;text/x-uuencode;text/x-vcalendar;text/x-vcard;application/x-cdlink;application/vnd.vsf;model/vrml;application/vnd.vcx;model/vnd.mts;model/vnd.vtu;application/vnd.visionary;video/vnd.vivo;applicatin/ccxml+xml,;application/voicexml+xml;application/x-wais-source;application/vnd.wap.wbxml;image/vnd.wap.wbmp;audio/x-wav;application/davmount+xml;application/x-font-woff;application/wspolicy+xml;image/webp;application/vnd.webturb;application/widget;application/winhlp;text/vnd.wap.wml;text/vnd.wap.wmlscript;application/vnd.wap.wmlscriptc;application/vnd.wordperfect;application/vnd.wt.stf;application/wsdl+xml;image/x-xbitmap;image/x-xpixmap;image/x-xwindowump;application/x-x509-ca-cert;application/x-xfig;application/xhtml+xml;application/xml;application/xcap-diff+xml;application/xenc+xml;application/patch-ops-error+xml;application/resource-lists+xml;application/rls-services+xml;aplication/resource-lists-diff+xml;application/xslt+xml;application/xop+xml;application/x-xpinstall;application/xspf+xml;application/vnd.mozilla.xul+xml;chemical/x-xyz;text/yaml;application/yang;application/yin+xml;application/vnd.ul;application/zip;application/vnd.handheld-entertainment+xml;application/vnd.zzazz.deck+xml");

			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.download.manager.focusWhenStarting", false);
			profile.setPreference("browser.download.useDownloadDir", true);
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.download.manager.closeWhenDone", true);
			profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			profile.setPreference("browser.download.manager.useWindow", false);
			profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
			profile.setPreference("pdfjs.disabled", true);
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			driver = new FirefoxDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(prop.getProperty("BaseUrl"));

		} else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			// create chrome instance
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadPath);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			// DesiredCapabilities cap = DesiredCapabilities.chrome();
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			// driver.get(prop.getProperty("baseUrl"));
			driver.get(prop.getProperty("baseUrl"));

		} else if (browser.equalsIgnoreCase("IE")) {
			// set path to Edge.exe
			System.setProperty("webdriver.edge.driver", ".\\MicrosoftWebDriver.exe");
			// create Edge instance
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(prop.getProperty("baseUrl"));
		}

	}

	@AfterTest
	public void tearDown() throws Exception {
		// driver.close();
		driver.quit();

	}

	// To Fill the input fields
	public void type(String locator, String text) {
		waitFor(locator);
		WebElement element = find(locator);
		element.clear();
		element.sendKeys(text);
	}

	// To click on the object
	public void click(String locator) {
		for (int i = 0; i < 5; i++) {
			try {
				waitFor(locator);
				find(locator).click();
				break;
			} catch (ElementNotInteractableException ex) { // from
															// org.openqa.selenium.ElementNotInteractableException
				continue;
			} catch (Exception e) { // Fail on all other exceptions
				System.out.println(e);
				break;
			}
		}
	}

	// To click on the javascript click
	public void JavaScriptclick(String locator) {
		for (int i = 0; i < 5; i++) {
			try {
				waitFor(locator);
				WebElement setElement = find(locator);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", setElement);
				break;
			} catch (ElementNotInteractableException ex) { // from
															// org.openqa.selenium.ElementNotInteractableException
				continue;
			} catch (Exception e) { // Fail on all other exceptions
				System.out.println(e);
				break;
			}
		}
	}

	// To right click on the element
	public void Rightclick(String locator) {

		waitFor(locator);
		WebElement setElement = find(locator);
		Actions actions = new Actions(driver);
		actions.contextClick(setElement).perform();
	}

	// To Double click on the element
	public void Doubleclick(String locator) {

		waitFor(locator);
		WebElement setElement = find(locator);
		Actions actions = new Actions(driver);
		actions.doubleClick(setElement).perform();
	}

	// To find the element in the DOM Structure
	public WebElement find(String locator) {
		By by = parseLocator(locator);
		List<WebElement> elements = driver.findElements(by);

		if (elements.size() == 0) {
			throw new AssertionError("Could not find any element matching '" + locator + "'");
			// return null;
		} else if (elements.size() > 1) {
			System.err.println("Found " + elements.size() + " elements matching '" + locator + "'");
		}
		return elements.get(0);
	}

	// Parsing the element from the parameter
	public By parseLocator(String locator) {
		By by;
		if (locator.startsWith("xpath=")) {
			String xpath = locator.substring("xpath=".length());
			by = By.xpath(xpath);
		} else if (locator.startsWith("//")) { // only implicit xpath supported
			by = By.xpath(locator);
		} else if (locator.startsWith("#") && locator.indexOf(" ") < 0 && locator.indexOf(".") < 0
				&& locator.indexOf(",") < 0) {
			by = By.id(locator.substring(1));
		} else {
			by = By.cssSelector(locator);
		}
		return by;
	}

	// check whether element exist or not in the DOM
	public boolean exists(String locator) {
		By by = parseLocator(locator);
		return driver.findElements(by).size() > 0;
	}

	// check element present
	public boolean isElementPresent(String locator) {
		return exists(locator);
	}

	// Wait for the element
	public void waitFor(String locator) {
		try {
			new WebDriverWait(driver, (TIMEOUT / 5000), 500)
					.until(ExpectedConditions.visibilityOfElementLocated(parseLocator(locator)));
		} catch (TimeoutException e) { // from
										// org.openqa.selenium.TimeoutException
			throw new AssertionError("Timeout during waiting for element: '" + locator + "'");
		}
	}

	// Wait for enable the element
	public void waitForEnable(String locator) {
		try {
			new WebDriverWait(driver, (TIMEOUT / 1000), 200)
					.until(ExpectedConditions.elementToBeClickable(parseLocator(locator)));
		} catch (TimeoutException e) { // from
										// org.openqa.selenium.TimeoutException
			throw new AssertionError("Timeout during waiting for element: '" + locator + "'");
		}
	}

	// Waiting for selected option present
	public void waitForSelectOption(String Locator) {
		try {

			new WebDriverWait(driver, (TIMEOUT / 1000), 200).until(
					ExpectedConditions.presenceOfNestedElementsLocatedBy(parseLocator(Locator), By.tagName("option")));

		} catch (TimeoutException e) { // from
										// org.openqa.selenium.TimeoutException
			throw new AssertionError("Timeout during waiting for element: '" + Locator + "'");
		}

	}

	// Waiting for the value present
	public void waitForvalue(String locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(
					ExpectedConditions.presenceOfNestedElementsLocatedBy(parseLocator(locator), By.tagName("value")));
		} catch (TimeoutException e) { // from
										// org.openqa.selenium.TimeoutException
			throw new AssertionError("Timeout during waiting for element: '" + locator + "'");
		}
	}

	// Switch to the frame id
	public void SwitchFrame(String locator) {
		WebElement frameElement = driver.findElement(By.id(locator));
		driver.switchTo().frame(frameElement);

	}

	// Switch to frame name.
	public void SwitchFrameName(String locator) {
		WebElement frameElement = driver.findElement(By.name(locator));
		driver.switchTo().frame(frameElement);

	}

	// To check the element
	public void check(String locator) {
		waitFor(locator);
		WebElement element = find(locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	// To uncheck the element
	public void uncheck(String locator) {

		WebElement checkbox = find(locator);
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	// To get the get the text from the DOM
	public String getText(String locator) {
		return getText(locator, true);
	}

	// To get the attribute value
	public String getValue(String locator) {
		return find(locator).getAttribute("value");
	}

	// To get the attribute details
	public String getAttribute(String locator, String Attribute) {
		return find(locator).getAttribute(Attribute);
	}

	// To check whether the element selected or not
	public boolean isSelected(String locator) {
		WebElement element = find(locator);
		return element.isSelected();
	}

	// To check whether the element displayed or not
	public boolean isDisplayed(String locator) {
		WebElement element = find(locator);
		return element.isDisplayed();
	}

	// To check whether the element enabled or not
	public boolean isEnabled(String locator) {
		WebElement element = find(locator);
		return element.isEnabled();
	}

	// To read alert message
	public String readAlertMessageText() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isAlertPresents()) {
			Alert alert = driver.switchTo().alert();
			String message = alert.getText();
			System.out.println(message);
			return message;
		} else {
			return null;
		}
	}

	// To accept the alert
	public void AcceptAlert() {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	// To Dismiss the alert
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		driver.switchTo().defaultContent();
	}

	// To get the text the dOM
	public String getText(String locator, boolean onlyVisible) {
		if (onlyVisible) {
			return find(locator).getText().trim();
		} else {
			WebElement e = find(locator);
			try {
				return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML", e);
			} catch (Exception ex) {
				throw new RuntimeException("Failed to return text for " + locator + " on web element " + e, ex);
			}
		}

	}

	// To generate random data.
	public String generateRandomData() {
		final String alphabet = "0123456789111213141516171819abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final int N = alphabet.length();
		char[] data = new char[10];
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			data[i] = alphabet.charAt(r.nextInt(N));
		}
		String RandomData = String.valueOf(data);
		return "QA" + RandomData;

	}

	// To generate random number
	public String generateRandomNumber() {
		final String alphabet = "0123456789";
		final int N = alphabet.length();
		char[] data = new char[10];
		Random r = new Random();
		for (int i = 0; i < 7; i++) {
			data[i] = alphabet.charAt(r.nextInt(N));
		}
		String RandomData = String.valueOf(data);
		// System.out.println(RandomData);
		return RandomData;

	}

	// To check Alert Presents
	public boolean isAlertPresents() {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (Exception e) {
			return false;
		} // catch
	}

	// To check whether extra tabs present.
	public void CheckExtraTabs() {
		String originalHandle = driver.getWindowHandle();

		// Do something to open new tabs

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);

	}

	// To select the drop down options
	public void select(String locator, String optionLocator) {
		Select select = new Select(find(locator));
		if (optionLocator.startsWith("index=")) {
			select.selectByIndex(Integer.parseInt(optionLocator.substring("index=".length())) - 1); // selectByIndex
																									// is
																									// zero-based,
																									// out
																									// api
																									// was
																									// 1-based
		} else if (optionLocator.startsWith("value=")) {
			select.selectByValue(optionLocator.substring("value=".length()));
		} else if (optionLocator.startsWith("label=")) {
			select.selectByVisibleText(optionLocator.substring("label=".length()));
		} else {
			select.selectByVisibleText(optionLocator);
		}
	}

	// To check selected drop down value.
	public String DropselectedValue(String locator) {
		Select selectElement = new Select(find(locator));
		WebElement Value = selectElement.getFirstSelectedOption();
		return Value.getText();
	}

	// To handle windows pop up
	public void Handle_windows_Popup() throws Exception {
		Robot object = new Robot();

		// Press Enter
		object.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		object.keyRelease(KeyEvent.VK_ENTER);

	}

	// To verify the file download (File name)
	protected boolean isFileDownloaded(String ext) {

		String DownloadLocation = "C:\\Users\\sebastian\\Downloads";

		// TODO Auto-generated method stub
		boolean flag = false;
		File dir = new File(DownloadLocation);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		for (int i = 1; i < files.length; i++) {
			if (files[i].getName().contains(ext)) {
				flag = true;
			}
		}
		return flag;
	}

	// to delete the file in the folder
	protected void FileDelete() {

		File dir = new File(downloadPath);
		if (!dir.exists()) {

			File theFile = new File("C:\\" + "Edinsightdownloads");
			theFile.mkdirs();
		}
		File[] files = dir.listFiles();

		for (int i = 0; i < files.length; i++) {

			if (files == null || files.length == 0) {
				break;
			} else {
				files[i].delete();
			}
		}

	}

	// To verify the file extension
	protected boolean isFileDownloaded_Ext(String ext) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().contains(ext)) {
				flag = true;
			}
		}
		return flag;
	}

	// To scroll Down to the end of the page
	public void Scroll_DowntoEnd() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// To scroll to top of the page
	public void Scroll_toTop() {
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
	}

	// To scroll to a specific location.
	public void ScrollTo_Location(String locator) {
		WebElement element = find(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	// Scroll to specific postion(x axis,y axis)
	public void ScrollTo_xy_position(int x, int y) {
		((JavascriptExecutor) driver).executeScript("scroll(" + x + "," + y + ")");

	}

	// To tkae the screen shot
	public void Takescreenshot(String ScreenshotName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshots/" + ScreenshotName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// returns the total count of rows in a csv
	public int csv_row_count() throws Exception {

		File folder = new File(downloadPath);
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.getName().contains(".csv")) {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(fileEntry));
				String input;
				int count = 0;
				while ((input = bufferedReader.readLine()) != null) {
					count++;
				}
				return count;
			}
		}
		return 0;
	}

	// Returns number of columns in a Csv in the given file path
	public int Csv_column_count(String file_path) {
		try {
			int csv_columnCount = 0;
			File folder = new File(file_path);
			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.getName().contains(".csv")) {
					CSVReader reader = new CSVReader(new FileReader(fileEntry));
					String[] header = reader.readNext();
					if (header != null) {
						csv_columnCount = header.length;
					}
				}
				return csv_columnCount;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	// Wait for download complete
	public void waitFor_downloadfile() {
		try {
			int i = 3000;
			int j = 0;
			File dir = new File(downloadPath);
			File[] files;
			do {
				Thread.sleep(i);
				files = dir.listFiles();

				j = j + 3000;
				System.out.println(j);
				if (j > 200000) {
					System.out.println("The maximum Time limit has Reached to 200000");
					break;
				}

			} while (files == null || files.length == 0);
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// waitThread method to call a Thread.sleep so that we don't have
	// to write a try-catch every time we want to sleep a thread
	public static void waitThread(int milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// To switch to the window using index
	public void switchToWindowindex(int windowNumber) {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		int i = 1;
		while (ite.hasNext() && i < 10) {
			String popupHandle = ite.next().toString();
			driver.switchTo().window(popupHandle);
			System.out.println("Window title is : " + driver.getTitle());
			if (i == windowNumber)
				break;
			i++;
		}
	}

	// To refresh the page
	public void PageRefresh() {

		driver.navigate().refresh();
	}

	// : Mouse Hover of a particular web element
	public void MouseHover(String locator) {
		Actions action = new Actions(driver);
		WebElement searchElmt = find(locator);
		action.moveToElement(searchElmt).perform();
	}

	// * : Total no.of web elements by same locator.
	public int TotalElementsCount(String locator) {
		int totalwebelmts = 0;
		totalwebelmts = driver.findElements(By.xpath(locator)).size();
		return totalwebelmts;
	}

	// Verify dropdown options list and total no.of list items.
	public boolean VerifyDropdownOptions(String locator, String[] Listlabels) {

		int totalitems = 0, totalwebelmts = 0;
		WebElement sst = driver.findElement(By.xpath(locator));
		Select select = new Select(sst);
		System.out.println(Listlabels.length);
		List<WebElement> options = select.getOptions();

		for (WebElement we : options) {
			totalwebelmts++;
			for (int i = 0; i < Listlabels.length; i++) {

				if (we.getText().trim().equals(Listlabels[i])) {
					totalitems++;
					System.out.println(Listlabels[i] + ":Pass");
					break;
				}

			}
		}
		System.out.println("Total List Items:" + Listlabels.length);
		System.out.println("Total Web Elements:" + totalwebelmts);
		System.out.println("Total Match Elements:" + totalitems);
		if (totalitems == Listlabels.length && totalwebelmts == Listlabels.length) {
			return true;
		} else {
			return false;
		}

	}

	// To click on the List data
	public void clickonList(String Locator, int index) {

		List<WebElement> elementlist = driver.findElements(By.xpath(Locator));

		elementlist.get(index).click();

	}

	// To get title
	public String getTitle() {
		return driver.getTitle();
	}

}
