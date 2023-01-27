# Présentation
Ce projet à but éducatif met en place un système avec une architecture de micro-services. Il utilise notamment Docker, Quarkus et Kubernetes (minikube). Un monitoring pour contrôler la santé du système avec des métriques a été mis en place.

# Fonctionnement
1. Redéfinissez l'environnement docker pour minikube avec : eval $(minikube docker-env)
2. Compilez (ou recompilez) et déployez chacun des 3 services en vous déplaçant au préalable dans leur répertoire.
    - Heroes : mvn clean package; docker build -f src/main/docker/Dockerfile.jvm -t hero .; kubectl delete deployment supes-hero; kubectl apply -f kubernetes/
    - Villains : mvn clean package; docker build -f src/main/docker/Dockerfile.jvm -t villain .; kubectl delete deployment supes-villain; kubectl apply -f kubernetes/
    - Fight : mvn clean package; docker build -f src/main/docker/Dockerfile.jvm -t fight .; kubectl delete deployment supes-fight; kubectl apply -f kubernetes/
3. Il est possible de vérifier l'état des services avec la commande suivante : kubectl get pods
4. Pour obtenir l'url du service fight et le tester, utilisez la commande : minikube service supes-fight --url

# Membres
- Damien Lombard
- Dorian Simon
- Sabrina Kacel
- Rémy Del Grosso
