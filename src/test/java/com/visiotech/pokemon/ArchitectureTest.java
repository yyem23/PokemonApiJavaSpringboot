package com.visiotech.pokemon;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest {

    private final JavaClasses classes = new ClassFileImporter()
            .importPackages("com.visiotech.pokemon");


    @Test
    void domainNoDebeDependenDeInfraestructura(){
        ArchRule rule = noClasses()
                .that().resideInAPackage("..domain..")
                .should().dependOnClassesThat()
                .resideInAPackage("..infrastructure..");
        rule.check(classes);
    }


    @Test
    void domainNoDebeDependenDeInterfaces(){
        ArchRule rule = noClasses()
                .that().resideInAPackage("..domain..")
                .should().dependOnClassesThat()
                .resideInAPackage("..interfaces..");
        rule.check(classes);

    }

    @Test
    void applicationNoDebeDependenDeInfraestructura() {
        ArchRule rule = noClasses()
                .that().resideInAPackage("..application..")
                .should().dependOnClassesThat()
                .resideInAPackage("..infrastructure..");
        rule.check(classes);
    }


    @Test
    void controllersDebenEstarEnInterfacesRest(){
        ArchRule rule = classes()
                .that().haveNameMatching(".*Controller")
                .should().resideInAPackage("..interfaces.rest..");
        rule.check(classes);

    }

    @Test
    void repositoriesDebenEstarEnInfraestructuraODominio(){
        ArchRule rule = classes()
                .that().haveNameMatching(".*Repository")
                .should().resideInAnyPackage("..domain.repository..", "..infrastructure.persistence..");
        rule.check(classes);

    }

}
