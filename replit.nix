{ pkgs }: {
    deps = [
      pkgs.adoptopenjdk-bin
      pkgs.zulu
      pkgs.import java.util.Collection;
        pkgs.graalvm17-ce
        pkgs.maven
        pkgs.replitPackages.jdt-language-server
        pkgs.replitPackages.java-debug
    ];
}