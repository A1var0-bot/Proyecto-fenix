// Ejemplo de prueba
@Test
void testProcesarListaComportamientoActual() {
    ProcesadorUsuarios procesador = new ProcesadorUsuarios();
    List<String> lista = List.of("Ana:1", "Luis:2", "Eva:1", "Juan:99");
    String resultado = procesador.procesarLista(lista);
    assertEquals("Admins: Ana,Eva, | Invitados: Luis,", resultado);
}