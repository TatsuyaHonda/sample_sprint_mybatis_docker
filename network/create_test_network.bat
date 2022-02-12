@echo ローカルネットワークを作成いたします
docker network create --driver bridge sample_localtest
docker network ls
pause