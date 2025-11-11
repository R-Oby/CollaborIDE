# CollaborIDE
Real-time collaborative IDE in the browser (very early scaffold)

## What’s here
* Spring-Boot 3.5 backend (Java 25)  
* Postgres 18 via Docker-Compose  
* Dockerfile & `docker-compose.yml` ready for local dev  
* Empty repo beyond that, so far.

## Quick start (Docker)
```bash
git clone https://github.com/R-Oby/CollaborIDE.git
cd CollaborIDE

# 1. start services
docker compose up --build
docker compose up -d


# 2. DB ready  (wait 3-4 s)
docker compose logs
```
