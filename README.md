<img width="1500" height="500" alt="baner-sembradata" src="https://github.com/user-attachments/assets/cf591af6-bd2d-4cbc-86ce-649c0911a0ca" />


# SembraData: Predicción Agroclimática — Santander

> **SembraData** es una plataforma web interactiva de analítica agroclimática predictiva diseñada para mitigar los riesgos climáticos y optimizar la toma de decisiones agrícolas en el **departamento de Santander, Colombia**. Cubre con precisión técnica los **87 municipios del departamento**, enfocándose en cultivos estratégicos (**Cacao, Café y Granadilla**), con observaciones climáticas en tiempo real, perfiles de suelo por profundidad, series históricas verificadas (EVA / MinAgricultura), pronósticos estadísticos reproducibles (Theil-Sen) y un asistente conversacional trazable libre de alucinaciones.

<br/>

![TanStack Start](https://img.shields.io/badge/TanStack_Start-1.168-3B82F6?style=for-the-badge)
![React](https://img.shields.io/badge/React-19-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-4-38BDF8?style=for-the-badge&logo=tailwindcss&logoColor=white)
![TypeScript](https://img.shields.io/badge/TypeScript-5.8-3178C6?style=for-the-badge&logo=typescript&logoColor=white)
![Supabase](https://img.shields.io/badge/Supabase-2.49-3FCF8E?style=for-the-badge&logo=supabase&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Node_22_Alpine-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Vercel](https://img.shields.io/badge/Vercel-Production-000000?style=for-the-badge&logo=vercel&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

</div>

  <h1 align="center"> Despliegue de la Aplicación </h1> 



> [!IMPORTANT]
> La versión de producción se encuentra desplegada y conectada a Supabase. Toda la información geográfica y agroclimática está delimitada a los 87 municipios de Santander.

<div align="center">

### [Abrir SembraData en Producción](https://231-sembradata-abierto-ia-avanzado.vercel.app/)

**`https://231-sembradata-abierto-ia-avanzado.vercel.app/`**

### [Sustentación y Documentación Ejecutiva](https://gamma.app/docs/Prediccion-Agroclimatica-Inteligente-vr0vp5qbfomjv4y)

<!-- VIDEO DE PRESENTACIÓN SEMBRADATA -->
<div align="center">
  <a href="https://www.youtube.com/watch?v=2j3pJan0OJU" target="_blank">
    <img src="https://img.youtube.com/vi/2j3pJan0OJU/maxresdefault.jpg?v=3" alt="Presentación SembraData" width="100%" style="border-radius: 8px;">
  </a>
  <p><i>▶️ Haz clic en la imagen para ver la presentación del proyecto en YouTube (2:27 min)</i></p>
</div>
<h1> Características principales </h1>

| Icono | Módulo / Característica                     | Descripción Técnica                                                                                                                                                                                                                                                                          |
| :---: | :------------------------------------------ | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|  🗺️   | **Mapa Coroplético de Santander**           | Visualización vectorial SVG de los **87 municipios** con selector geográfico y clasificación por zonas agroecológicas y niveles de riesgo.                                                                                                                                                   |
|  📈   | **Histórico vs. Predicción**                | Series históricas observadas de **EVA / MinAgricultura** contrastadas con proyecciones estadísticas del motor **Theil-Sen / Rolling Origin** con intervalos de predicción al 80% y 95% ($L_{80}, U_{80}, L_{95}, U_{95}$). **0 datos sintéticos** (requiere $N \ge 3$ observaciones reales). |
|  🤖   | **Chatbot Agroclimático Trazable**          | Asistente inteligente respaldado por servicios deterministas del servidor, validación geográfica contra el catálogo de Santander, RAG con umbral de relevancia $\ge 3.0$, modelo Groq (`openai/gpt-oss-20b`) y sanitizador anti-alucinaciones con acordeón de afirmaciones verificadas.      |
|  🧪   | **Evaluación Agronómica Gemini**            | Edge Function (`gemini-assessment`) con **Google Gemini 2.0 Flash** para emitir evaluación cualitativa de consistencia biológica sin alterar los valores numéricos del modelo estadístico.                                                                                                   |
|  ⛅   | **Clima en Vivo (Open-Meteo)**              | Monitoreo meteorológico en tiempo real, pronóstico a 7 días y balance hídrico sin requerir claves de API expuestas.                                                                                                                                                                          |
|  🛰️   | **Validación Satelital (NASA POWER)**       | Radiación solar, evapotranspiración de referencia y variables agroclimáticas históricas.                                                                                                                                                                                                     |
|  📡   | **Estaciones IDEAM**                        | Integración con datos abiertos de estaciones meteorológicas oficiales del IDEAM vía Socrata (datos.gov.co).                                                                                                                                                                                  |
|  🪨   | **Propiedades del Suelo (SoilGrids ISRIC)** | Perfiles pedológicos por profundidad (pH en $H_2O$, materia orgánica, textura, arena/arcilla/limo).                                                                                                                                                                                          |
|  📊   | **Mercado Internacional y Nacional**        | Cotizaciones de referencia internacional (ICE Cocoa CC / Coffee KC) y nacional (DANE SIPSA Centroabastos) con estrategia _Stale-While-Revalidate_ y análisis de presión climática.                                                                                                           |
|  🛡️   | **Arquitectura Conectada Segura**           | Aplicación estrictamente conectada con indicador de red en tiempo real, políticas RLS (Migración 009), dataset EVA 2018–2024 (Migración 010), tabla de cuarentena de calidad de datos y frontend de solo lectura.    

<!--Apartado de arquitectura -->
<H1> Arquitectura del sistema </H1>

<img width="1024" height="559" alt="imagen" src="https://github.com/user-attachments/assets/235f6895-6429-433f-ab52-ae28d5ebff1f" /><div align="center">


## 🎯 Objetivo del Proyecto

**SembraData** resuelve la problemática de la toma de decisiones agrícolas bajo incertidumbre climática en el departamento de Santander, Colombia. La plataforma integra:

- **Datos históricos oficiales** del Ministerio de Agricultura (EVA 2018–2024)
- **Variables agroclimáticas satelitales** (NASA POWER, Open-Meteo)
- **Perfiles pedológicos** (SoilGrids ISRIC)
- **Estaciones meteorológicas oficiales** (IDEAM vía Socrata)
- **Modelos estadísticos robustos** (Theil-Sen + Rolling Origin) con intervalos de confianza al 80% y 95%
- **Asistentes de IA** (Groq GPT-OSS-20B, Google Gemini 2.0 Flash) con validación geográfica y sanitización anti-alucinaciones

### Propuesta de Valor

| Stakeholder | Beneficio |
|-------------|-----------|
| **Agricultores** | Predicción de rendimiento y riesgo agroclimático por municipio y cultivo |
| **Entidades gubernamentales** | Dashboard centralizado con datos abiertos validados y trazables |
| **Investigadores** | Motor estadístico reproducible sin datos sintéticos (requiere N ≥ 3 observaciones reales) |
| **Mercado** | Cotizaciones internacionales (ICE Cocoa/Coffee) y nacionales (DANE SIPSA) con análisis de presión climática |

---

## 🛠 Stack Tecnológico

### Frontend
| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **React** | 19.2.0 | Biblioteca UI declarativa con Concurrent Features |
| **TanStack Start** | 1.168+ | Framework full-stack con SSR, file-based routing y streaming |
| **TanStack Router** | 1.170+ | Enrutamiento tipado con preload y code-splitting automático |
| **TanStack React Query** | 5.101+ | Gestión de estado servidor, caching y sincronización |
| **Tailwind CSS** | 4.2.1 | Utility-first CSS con @tailwindcss/vite |
| **Radix UI** | 2.2+ | Primitives accesibles (Select, Slot) |
| **Lucide React** | 0.575+ | Iconografía vectorial |
| **Vaul** | 1.1+ | Drawer/modal primitives |
| **Embla Carousel** | 8.6+ | Carruseles táctiles |
| **Sonner** | 2.0+ | Notificaciones toast |
| **React Hook Form + Zod** | 7.82+ / 3.24+ | Formularios tipados con validación esquemática |

### Backend / Servicios
| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Supabase PostgreSQL** | 15+ | Base de datos relacional con RLS, PostGIS-ready |
| **Supabase Edge Functions** | Deno 2.x | FaaS serverless para chatbot y evaluación agronómica |
| **Vite** | 8.0+ | Bundler y dev server con HMR |
| **Nitro** | 3.0+ (beta) | Motor de producción para SSR/SSG |

### IA / Machine Learning
| Tecnología | Modelo / Servicio | Propósito |
|------------|-------------------|-----------|
| **Groq Cloud API** | `openai/gpt-oss-20b` | Chatbot agroclimático con RAG y motor determinista |
| **Google Generative Language** | Gemini 2.0 Flash | Evaluación cualitativa de consistencia biológica |
| **Motor Estadístico Propio** | Theil-Sen + Rolling Origin | Predicción de rendimiento con intervalos L₈₀/U₈₀ y L₉₅/U₉₅ |

### Visualización / GIS / Mapas
| Tecnología | Propósito |
|------------|-----------|
| **SVG Vectorial Nativo** | Mapa coroplético de 87 municipios de Santander |
| **CSS Gradients + Tailwind** | Clasificación por zonas agroecológicas y niveles de riesgo |

### Monitoreo y Calidad
| Tecnología | Propósito |
|------------|-----------|
| **Sentry** | 10.69+ | Error tracking, performance monitoring y session replay |
| **Lovable Error Reporting** | Telemetría de errores en边界 de componentes |

---


## 🔌 APIs, Modelos y Fuentes de Datos

### Endpoints Externos Consumidos

| API | Endpoint Base | Datos | Autenticación |
|-----|---------------|-------|---------------|
| **Open-Meteo** | `https://api.open-meteo.com/v1/` | Clima actual, pronóstico 7 días, balance hídrico | Sin clave (CORS abierto) |
| **NASA POWER** | `https://power.larc.nasa.gov/api/` | Radiación solar, ET₀, temperaturas históricas | Sin clave |
| **IDEAM Socrata** | `https://www.datos.gov.co/resource/` | Estaciones meteorológicas oficiales | Token Socrata (opcional) |
| **SoilGrids ISRIC** | `https://rest.isric.org/soilgrids/v2.0/` | pH, materia orgánica, textura por profundidad | Sin clave |
| **Groq Cloud** | `https://api.groq.com/openai/v1/` | LLM `openai/gpt-oss-20b` | `GROQ_API_KEY` (Edge Function) |
| **Google Generative AI** | `https://generativelanguage.googleapis.com/` | Gemini 2.0 Flash | `GEMINI_API_KEY` (Edge Function) |

### Endpoints Propios (Edge Functions)

| Ruta | Método | Descripción |
|------|--------|-------------|
| `/.netlify/functions/chat` | `POST` | Chatbot con validación geográfica, RAG (umbral ≥ 3.0), sanitizador |
| `/.netlify/functions/gemini-assessment` | `POST` | Evaluación cualitativa de consistencia biológica sin alterar valores numéricos |

### Modelos Predictivos

| Modelo | Tipo | Variables de Entrada | Variables de Salida |
|--------|------|---------------------|---------------------|
| **Theil-Sen Regressor** | Estadístico robusto (no paramétrico) | Año, área sembrada, precipitación acumulada, radiación solar | Rendimiento proyectado (t/ha) |
| **Rolling Origin Validation** | Validación temporal walk-forward | Serie histórica EVA 2018–2024 | Intervalos de predicción L₈₀, U₈₀, L₉₅, U₉₅ |

> **Restricción de calidad:** El motor rechaza predicciones si N < 3 observaciones reales. **Cero datos sintéticos.**

### Datasets de Entrenamiento

| Fuente | Periodo | Cobertura | Formato |
|--------|---------|-----------|---------|
| **EVA — MinAgricultura** | 2018–2024 | 87 municipios de Santander | PostgreSQL (Migración 010) |
| **NASA POWER** | 1984–presente | Grilla 0.5° × 0.5° | JSON API + caché PostgreSQL |
| **IDEAM** | Variable por estación | Estaciones dentro del departamento | Socrata JSON + caché |

---

