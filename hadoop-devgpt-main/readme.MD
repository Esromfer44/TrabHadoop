# Projeto Hadoop MapReduce

Este projeto é um exemplo de aplicação Hadoop MapReduce para processar dados relacionados a compartilhamento de arquivos. O código contém três classes principais: `FileNameFileSharingsMapper`, `TypeFileSharingsMapper` e `FileSharingsReducer`, que implementam as etapas de mapeamento e redução.

## Estrutura do Projeto

- **FileNameFileSharingsMapper.java**: Esta classe contém a lógica de mapeamento para extrair e processar informações específicas de arquivos do tipo "FileName".

- **TypeFileSharingsMapper.java**: Esta classe representa a lógica de mapeamento para extrair e processar informações específicas de arquivos do tipo "Type".

- **FileSharingsReducer.java**: Esta classe implementa a lógica de redução para agregar e contabilizar as ocorrências de palavras chave.

## Funcionamento

1. **FileNameFileSharingsMapper**:
   - Lê linhas de entrada e verifica se contêm a palavra-chave "FileName".
   - Extrai o último item após o ponto em cada linha e o processa, mantendo apenas caracteres alfabéticos em minúsculas.
   - Emite pares chave-valor, onde a chave é o último item processado e o valor é sempre 1.

2. **TypeFileSharingsMapper**:
   - Lê linhas de entrada e verifica se contêm a palavra-chave "Type".
   - Processa a palavra seguinte, mantendo apenas caracteres alfabéticos em minúsculas.
   - Emite pares chave-valor, onde a chave é a palavra processada e o valor é sempre 1.

3. **FileSharingsReducer**:
   - Recebe pares chave-valor do mapeamento.
   - Agrega e contabiliza as ocorrências de cada chave, emitindo pares chave-valor onde a chave é a palavra processada e o valor é a contagem total.

## Executando o MapReduce

Para executar este projeto no ambiente Hadoop, siga estas etapas:

1. **Compilação do código**:
   - Compile o código Java usando o compilador Hadoop:

     ```bash
     javac -classpath $HADOOP_HOME/share/hadoop/common/hadoop-common-<version>.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-<version>.jar -d output_directory FileNameFileSharingsMapper.java TypeFileSharingsMapper.java FileSharingsReducer.java
     ```

2. **Empacotamento em um JAR**:
   - Crie um arquivo JAR contendo os arquivos compilados:

     ```bash
     jar -cvf file-sharings.jar -C output_directory/ .
     ```

3. **Execução no Hadoop**:
   - Execute o MapReduce no Hadoop:

     ```bash
     hadoop jar file-sharings.jar org.example.FileNameFileSharingsDriver input_directory output_directory
     ```

     Substitua `input_directory` e `output_directory` pelos diretórios de entrada e saída desejados.

Este README fornece uma visão geral do projeto e das etapas necessárias para executá-lo no ambiente Hadoop. Certifique-se de ajustar os caminhos e comandos conforme necessário para a sua configuração específica.