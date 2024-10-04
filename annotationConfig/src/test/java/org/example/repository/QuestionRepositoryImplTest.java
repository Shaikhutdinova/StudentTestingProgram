package org.example.repository;

import org.example.model.Answer;
import org.example.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class QuestionRepositoryImplTest {

    @InjectMocks
    private QuestionRepositoryImpl questionRepository;

    @Mock
    private Resource questionsResource;

    @Test
    public void testFindAllQuestions() throws IOException {
        // Ожидаемые вопросы
        List<Question> expectedQuestions = Arrays.asList(
                new Question("Вопрос 1", Arrays.asList(
                        new Answer("Ответ 1", true),
                        new Answer("Ответ 2", false)
                ), 1),
                new Question("Вопрос 2", Arrays.asList(
                        new Answer("Ответ 3", true),
                        new Answer("Ответ 4", false)
                ), 1)
        );

        // Мокирование InputStreamReader
        BufferedReader mockReader = Mockito.mock(BufferedReader.class);
        Mockito.when(mockReader.readLine()).thenReturn("Question,Answer1,true,Answer2,false")
                .thenReturn("Question 2,Answer 3,true,Answer 4,false")
                .thenReturn(null);

        // Мокирование InputStream
        InputStreamReader mockInputStreamReader = Mockito.mock(InputStreamReader.class);
//        Mockito.when(mockInputStreamReader.getReader()).thenReturn(mockReader);

        // Мокирование Resource
//        Mockito.when(questionsResource.getInputStream()).thenReturn(mockInputStreamReader);

        // Вызов метода и проверка результата
        List<Question> actualQuestions = questionRepository.findAllQuestions();
        assertEquals(expectedQuestions, actualQuestions);
    }
}

