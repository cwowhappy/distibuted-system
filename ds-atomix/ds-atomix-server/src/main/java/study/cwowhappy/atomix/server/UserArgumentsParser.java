package study.cwowhappy.atomix.server;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserArgumentsParser {
    private static final Logger LOG = LoggerFactory.getLogger(UserArgumentsParser.class);
    private static Options options = new Options();
    private static Option help = new Option( "help", "print this message" );
    private static Option projecthelp = new Option( "projecthelp", "print project help information" );
    private static Option version = new Option( "version", "print the version information and exit" );
    private static Option quiet = new Option( "quiet", "be extra quiet" );
    private static Option verbose = new Option( "verbose", "be extra verbose" );
    private static Option debug = new Option( "debug", "print debugging information" );
    private static Option emacs = new Option( "emacs", "produce logging information without adornments" );
    private static Option logfile   = Option.builder("logfile").argName("file").hasArg().desc("use given file for log").build();

    private static Option logger    = OptionBuilder.withArgName( "classname" )
            .hasArg()
            .withDescription( "the class which it to perform "
                    + "logging" )
            .create( "logger" );

    private static Option listener  = OptionBuilder.withArgName( "classname" )
            .hasArg()
            .withDescription( "add an instance of class as "
                    + "a project listener" )
            .create( "listener");

    private static Option buildfile = OptionBuilder.withArgName( "file" )
            .hasArg()
            .withDescription(  "use given buildfile" )
            .create( "buildfile");

    private static Option find      = OptionBuilder.withArgName( "file" )
            .hasArg()
            .withDescription( "search for buildfile towards the "
                    + "root of the filesystem and use it" )
            .create( "find" );
    private static Option property  = OptionBuilder.withArgName( "property=value" )
            .hasArgs(2)
            .withValueSeparator()
            .withDescription( "use value for given property" )
            .create( "D" );
    static {
        options.addOption( help );
        options.addOption( projecthelp );
        options.addOption( version );
        options.addOption( quiet );
        options.addOption( verbose );
        options.addOption( debug );
        options.addOption( emacs );
        options.addOption( logfile );
        options.addOption( logger );
        options.addOption( listener );
        options.addOption( buildfile );
        options.addOption( find );
        options.addOption( property );
    }

    public static void main(String[] args) {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp("Ant", options);
    }
}
