
# Knock Knock Object Store

## Introduction
This project is a threaded server version of the oracle Knock Knock example. It also leverages Spring/JPA in order to be more useful. I have written the installation procedure assuming that one is running on Fedora. The methodology still applies for both windows and other UNIX variants, but the installation procedure may be slightly different.

* If running Windows, use the installers and set the HOME and PATH variables using the control panel
* If running a UNIX variant, replace the DNF commands with your operating system's package manager

## Installation

### Java/Maven Installation
1. Download the latest copies of the JDK and Maven
  * Load the tgz files onto the target machine
  * Set up a base folder:
    * ```mkdir /usr/local/java```

2. Extract both the maven and java tar balls to java:
  * ```tar -xvf <jdk.tar.gz> -C /usr/local/java```
  * ```tar -xvf <maven.tar.gz> -C /usr/local/java```

3. Symlink your versions to generic version
  * ```ln -s /usr/local/java/jdk-<your version> /usr/local/java/jdk```
  * ```ln -s /usr/local/java/apache-maven-<your version>```

4. Add the proper HOME locations and add to path:
   * Add the following contents to ```/etc/profile.d/java.sh```
```console
export JAVA_HOME='/usr/local/java/jdk'    
export PATH="$PATH:$JAVA_HOME/bin"    
export M2_HOME='/usr/local/java/maven'
export PATH="$PATH:$M2_HOME/bin"
```

5. Run the following to make the profile source-able:
  * ```chmod 644 /etc/profile.d/java.sh```

6. Source the additional profile information
   * Either ```. ~/.bashrc``` OR ```. /etc/profile.d/java.sh```

7. Verify that your installation is working
   * ``java -version```
   * ```mvn -version```

### Postgres Installation

1. Install Postgres
  * Run the following:
    * ```dnf install postgresql-server```
    * ```postgresql-setup --initdb```
    * ```systemctl start postgresql```

2. Set a password for the postgres user
   * ```sudo su - postgres```
   * ```psql```
   * ```\password postgres # Set to postgres```

3. Modify the configuration to accept passwords on localhost
   * ```sudo su -```
   * ```vi /var/lib/pgsql/data/pg_hba.conf```
   * Look at the end of the file, it should read as:
```console
# TYPE  DATABASE        USER            ADDRESS                 METHOD
# "local" is for Unix domain socket connections only
local   all             all                                     peer
# IPv4 local connections:
host    all             all             127.0.0.1/32            md5
# IPv6 local connections:
host    all             all             ::1/128                 ident
# Allow replication connections from localhost, by a user with the
# replication privilege.
#local   replication     postgres                                peer
#host    replication     postgres        127.0.0.1/32            ident
#host    replication     postgres        ::1/128                 ident
```

  * I changed the second line to use md5 authentication for connections on localhost

## Running the project
  * ```mvn clean compile package```
  * ```java -jar kk-server/target/kk-server-1.0-SNAPSHOT.jar```
  * ```java -jar kk-client/target/kk-client-1.0-SNAPSHOT.jar```

## Further Work
* I need to write both the client and server classes to take advantage of the threaded/connected server
