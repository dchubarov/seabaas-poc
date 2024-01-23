# SeaBaaS - Proof of Concept

## Overview

_Backend-as-a-Service_ (BaaS) refers to a platform that automates 
backend side development.

## Project goals
 
 * Read schema files on startup from a designated directory.
 * Maintain an in-memory persistence layer for schema and data.
 * Expose schema objects via REST API according to schema.
 * Stream data updates via Web Socket.
 * Support multiple backends.
 * Provide a minimalistic UI for administration:
   * Build and JVM information.
   * List of problems occurred while loading source schemas.
   * Server status, endpoints and their statistics.
 * Docker and Kubernetes deployment.