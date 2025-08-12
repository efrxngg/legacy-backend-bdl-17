# Proyecto Base Spring Boot

Este proyecto base implementa una **arquitectura hexagonal (Ports & Adapters)** siguiendo **mejores prácticas de desarrollo** para garantizar escalabilidad, mantenibilidad y flexibilidad ante cambios tecnológicos.

---

## 1. Arquitectura

La **arquitectura hexagonal** organiza el código en capas independientes, separando la lógica de negocio (dominio) de las tecnologías específicas (adaptadores). Esto facilita la sustitución de componentes sin afectar la lógica central.

**Estructura de paquetes:**

```plaintext
src/main/java/com/bancodellitoral
├── shared                   # Código y utilidades compartidas
│   ├── domain               # Abstracciones y objetos de dominio reutilizables
│   └── infrastructure       # Implementaciones comunes (configuración, utilidades técnicas)
├── {bounded-context}        # Módulos funcionales (ej: core, SWI, etc.)
│   ├── application          # Casos de uso / Servicios de aplicación
│   │   ├── services         # Lógica de orquestación
│   ├── domain               # Lógica de negocio
│   │   ├── entities         # Entidades del dominio
│   │   ├── repositories     # Interfaces de acceso a datos
│   │   └── services         # Servicios de dominio
│   └── infrastructure       # Adaptadores a tecnología
│       ├── persistence      # Implementaciones de acceso a datos
│       ├── rest             # Controladores REST
│       └── config           # Configuración específica del módulo
└── configuration
    └── spring               # Configuración global de Spring
```

---

## 2. Ambientes

El proyecto contempla dos ambientes principales:

### 2.1 Desarrollo

* **Servidor:** Embebido (Tomcat integrado en Spring Boot)
* **Sistema de logs:** Configuración similar a WildFly para facilitar pruebas locales
* **Archivo de configuración:** `application-dev.properties`

### 2.2 Producción

* **Servidor:** WildFly preconfigurado
* **Archivo de configuración:** `application.properties`

---

## 3. Sistema de Logs

La trazabilidad es fundamental para el soporte y mantenimiento.

* **Generación de logs:** Usar la anotación `@Slf4j` de Lombok para inyección automática del logger.
* **Variables a propagar:**

    * `application-dev.properties` (Desarrollo)
    * `jboss-logging.properties` (Producción)

Ejemplo de uso:

```java
@Slf4j
public class EjemploService {
    public void ejecutar() {
        log.info("Proceso iniciado para usuario {}", usuarioId);
    }
}
```

---

## 4. Configuración de Perfiles

Para cambiar el perfil activo, usar la opción de máquina virtual (VM Options):

```bash
-Dspring.profiles.active=dev
```

> 💡 **Recomendación:** Mantener `application.properties` como configuración base y sobrescribir solo lo necesario en cada perfil para evitar inconsistencias.

---

## 5. Context Path

El **servlet-path** debe coincidir con:

1. El **context path** deseado
2. El **nombre final del WAR** generado para despliegue en WildFly

---

## 6. Nota para Desarrollo

Si experimentas problemas al alternar entre ambientes:

1. Desarrolla inicialmente con `application.properties`
2. Antes del pase a producción, ajusta valores y propiedades específicas en `application-dev.properties` o el perfil correspondiente

---

## 7. Documentación Adicional

### 7.1 Diagrama de Arquitectura

<img src="/docs/h-architecture.excalidraw.png" alt="Arquitectura del Controller"></img>

---

## 8. Tecnologías Principales

* **Java** – Lenguaje principal de desarrollo
* **Spring Boot** – Framework para aplicaciones empresariales
* **Maven** – Gestión de dependencias y construcción
* **WildFly** – Servidor de aplicaciones para producción

---

## 9. Tabla de Buenas Prácticas

| Categoría                   | Buena Práctica                                                                                 | Beneficio Principal                                |
| --------------------------- |------------------------------------------------------------------------------------------------| -------------------------------------------------- |
| **Estructura de Código**    | Mantener la arquitectura hexagonal estricta: separar dominio, aplicación e infraestructura     | Favorece la mantenibilidad y escalabilidad         |
| **Nombres de Paquetes**     | Usar nombres significativos y en minúsculas, evitando abreviaturas ambiguas                    | Facilita la comprensión por nuevos desarrolladores |
| **Entidades**               | No incluir lógica de infraestructura (persistencia, API) en las entidades de dominio           | Preserva la independencia de la lógica de negocio  |
| **Servicios de Aplicación** | Orquestar casos de uso sin lógica de negocio compleja                                          | Mantiene claridad en responsabilidades             |
| **Persistencia**            | Implementar repositorios a través de interfaces en el dominio y adaptadores en infraestructura | Facilita el cambio de tecnología de base de datos  |
| **Configuración**           | Usar perfiles (`application-*.properties`) y variables de entorno                              | Permite despliegues portables y seguros            |
| **Logs**                    | Usar niveles de log apropiados (`INFO`, `WARN`, `ERROR`) y evitar logging excesivo             | Reduce ruido y facilita diagnósticos               |
| **Tests**                   | Mantener pruebas unitarias en dominio y pruebas de integración en infraestructura              | Mejora calidad y detecta errores temprano          |
| **Control de Versiones**    | Seguir convenciones de commits (ej: Semver y Conventional Commits)                             | Facilita el historial y las integraciones CI/CD    |
| **Documentación**           | Mantener README y diagramas actualizados                                                       | Ayuda en la incorporación de nuevos miembros       |
