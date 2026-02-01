# Para publicar a Calculadora de CO2 no GitHub Pages



1. \[GitHub] Criar um novo repositório no GitHub
2. \[GitHub] Copiar o local do repositório para usar com SSH
3. \[Computador] Abrir uma sessão de Terminal e entrar no diretório da aplicação Web (o mesmo onde está o arquivo "index.html")
4. \[Computador] Executar o comando: github clone <caminho\_SSH\_copiado\_no\_passo\_anterior>
5. \[GitHub] Ir em Settings/Pages e associar o repositório criado (o repositório tem que ser Public), escolher a opção GitHub Actions
6. \[Computador] Executar o "script" (feito para o GitHub Chat) para publicar o conteúdo local do site no GitHub
7. \[Computador] Caso o arquivo tenha sido criado fora do diretório da aplicação Web, mover a pasta ".github/\*" para a raiz do diretório da aplicação Web (no mesmo nível do arquivo "index.html")
8. \[Computador] Executar o comando: git add \*
9. \[Computador] Executar o comando: git add .github/workflows/deploy.yml
10. \[Computador] Executar o comando: git commit -m "Deploy pagina credito carbono"
11. \[Computador] Executar o comando: git push
12. \[GitHub] No repositório, ir no menu Actions e ativar actions no repositório
13. \[GitHub] Clicar na opção "Deploy to GitHub Pages" (está do lado esquerdo da tela de Actions). Caso não funcione, clicar na opção "Run Workflow" (do lado direito do painel central da tela de Actions)



TODO: Acessar o repositório do Pablo para conferir os códigos: https://github.com/pablonunes/CalculadoraCO2





