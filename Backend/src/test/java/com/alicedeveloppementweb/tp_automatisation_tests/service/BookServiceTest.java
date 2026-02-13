package com.alicedeveloppementweb.tp_automatisation_tests.service;

import com.alicedeveloppementweb.tp_automatisation_tests.model.Book;
import com.alicedeveloppementweb.tp_automatisation_tests.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService service;

    @Test
    void should_create_book() {
        // ARRANGE
        Book book = new Book(null, "1984", "Orwell", 1948);

        // ACT
        when(repository.save(book)).thenReturn(
                new Book(1L, "1984", "Orwell", 1948)
        );

        Book saved = service.create(book);

        // ASSERT
        assertNotNull(saved.getId());
        assertEquals("1984", saved.getTitre());
        verify(repository).save(book);
    }
}
